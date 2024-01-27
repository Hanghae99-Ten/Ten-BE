package com.sparta.ten.accounts.service;

import com.sparta.ten.accounts.domain.Account;
import com.sparta.ten.accounts.domain.AccountRoleEnum;
import com.sparta.ten.accounts.domain.RefreshToken;
import com.sparta.ten.accounts.domain.TokenType;
import com.sparta.ten.accounts.dto.AccountDto;
import com.sparta.ten.accounts.dto.AccountDtoMapper;
import com.sparta.ten.accounts.repository.AccountRepository;
import com.sparta.ten.accounts.repository.RefreshTokenRepository;
import com.sparta.ten.exception.CustomException;
import com.sparta.ten.exception.message.ErrorMsg;
import com.sparta.ten.exception.message.SuccessMsg;
import com.sparta.ten.jwt.JwtUtil;
import com.sparta.ten.util.StatusResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseCookie;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.sparta.ten.exception.message.SuccessMsg.SIGN_UP_SUCCESS;

@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public StatusResponseDto<?> signup(@Valid AccountDto.Signup signup) {
        if(!signup.getPassword().equals(signup.getPasswordCheck())) {
            throw new CustomException(ErrorMsg.NOT_MATCH_CHECK_PASSWORD);
        }

        String email = signup.getAccountUserId();
        String password = passwordEncoder.encode(signup.getPassword());
        String nickName = signup.getAccountName();

        Optional<Account> foundAccountUserId = accountRepository.findByAccountUserId(signup.getAccountUserId());
        if(foundAccountUserId.isPresent()) {
            Account account = foundAccountUserId.get();
            if(account.isActive()) {
                account.setActive(false);
                accountRepository.save(account);
                return StatusResponseDto.success(SIGN_UP_SUCCESS);
            }
            throw new CustomException(ErrorMsg.DUPLICATE_ACCOUNT_ID);
        }

        Account account = new Account(email, password, nickName);
        accountRepository.save(account);
        return StatusResponseDto.success(SIGN_UP_SUCCESS.getMessage());

    }

    public StatusResponseDto<AccountDto.LoginResponse> login(AccountDto.LoginRequest loginRequest, HttpServletResponse response) throws UnsupportedEncodingException {
        String accountUserId = loginRequest.getAccountUserId();
        String password = loginRequest.getPassword();

        Account account = accountRepository.findByAccountUserId(accountUserId).orElseThrow(
                () -> new CustomException(ErrorMsg.NOT_FOUND_ACCOUNT)
        );

        if(!passwordEncoder.matches(password, account.getPassword())) {
            throw new CustomException(ErrorMsg.NOT_MATCH_PASSWORD);
        }

        getAccessToken(account, response);
        getRefreshToken(account, response);

//        response.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(account.getAccountUserId(), AccountRoleEnum.USER));

        return StatusResponseDto.success(new AccountDto.LoginResponse(account));


    }

    private void getRefreshToken(Account account, HttpServletResponse response) throws UnsupportedEncodingException {
        String createRefreshToken = jwtUtil.createToken(account.getAccountUserId(), account.getAccountRole(), TokenType.REFRESH);
        ResponseCookie cookie = ResponseCookie.from(
                JwtUtil.REFRESH_HEADER, URLEncoder.encode(createRefreshToken, "UTF-8"))
                .path("/")
                .httpOnly(true)
                .sameSite("None")
                .secure(true)
                .maxAge(JwtUtil.REFRESH_TOKEN_TIME)
                .build();
        response.addHeader("Set-Cookie", cookie.toString());

        Optional<RefreshToken> refreshToken = refreshTokenRepository.findByAccountUserId(account.getAccountUserId());
        Long expiration = JwtUtil.REFRESH_TOKEN_TIME / 1000;

        if(refreshToken.isPresent()) {
            RefreshToken saveedRefreshToken = refreshToken.get().updateToken(createRefreshToken);
            refreshTokenRepository.save(saveedRefreshToken);
        } else {
            RefreshToken newRefreshToken = new RefreshToken(createRefreshToken, account.getAccountUserId());
            refreshTokenRepository.save(newRefreshToken);
        }
    }

    private void getAccessToken(Account account, HttpServletResponse response) throws UnsupportedEncodingException {
        String createdAccessToken = jwtUtil.createToken(account.getAccountUserId(), account.getAccountRole(), TokenType.ACCESS);

        log.info("token : " + createdAccessToken);

        // 4. JWT 토큰 반환
        ResponseCookie cookie = ResponseCookie.from(
                JwtUtil.AUTHORIZATION_HEADER, URLEncoder.encode(createdAccessToken, "UTF-8"))
                .path("/")
                .httpOnly(true)
                .sameSite("None")
                .secure(true)
                .maxAge(JwtUtil.ACCESS_TOKEN_TIME)
                .build();
        response.addHeader("Set-Cookie", cookie.toString());
    }

    //TODO: 현재는 사용하지 않는 로직이지만 추후 Redis 적용 시 필요
//    public static String getClientIp(HttpServletRequest request) {
//        String clientIp = null;
//        boolean isIpInHeader = false;
//
//        List<String> headerList = new ArrayList<>();
//        headerList.add("X-Forwarded-For");
//        headerList.add("HTTP_CLIENT_IP");
//        headerList.add("HTTP_X_FORWARDED_FOR");
//        headerList.add("HTTP_X_FORWARDED");
//        headerList.add("HTTP_FORWARDED_FOR");
//        headerList.add("HTTP_FORWARDED");
//        headerList.add("Proxy-Client-IP");
//        headerList.add("WL-Proxy-Client-IP");
//        headerList.add("HTTP_VIA");
//        headerList.add("IPV6_ADR");
//
//        for (String header : headerList) {
//            clientIp = request.getHeader(header);
//            if (StringUtils.hasText(clientIp) && !clientIp.equals("unknown")) {
//                isIpInHeader = true;
//                break;
//            }
//        }
//
//        if (!isIpInHeader) {
//            clientIp = request.getRemoteAddr();
//        }
//
//        return clientIp;
//    }

    // 액세스 토큰 재발급.
    @Transactional(readOnly = true)
    public StatusResponseDto<String> reIssueAccessToken(Account account, HttpServletResponse httpServletResponse) throws UnsupportedEncodingException {
        // Redis 서버에서 RefreshToken 점검.
        RefreshToken refreshToken = refreshTokenRepository.findByAccountUserId(account.getAccountUserId()).orElseThrow(
                () -> new CustomException(ErrorMsg.NOT_FOUND_REFRESH_TOKEN));

        //TODO: Redis 사용 시 필요한 코드
        //Ip가 다르면 RefreshToken 제거.
//        if (!getClientIp(httpServletRequest).equals(refreshToken.getIp())) {
//            refreshTokenRepository.deleteById(account.getAccountUserId());
//            throw new CustomException(ErrorMsg.NotMatchedIp);
//        }

        getAccessToken(account, httpServletResponse);
        return StatusResponseDto.success(SuccessMsg.TOKEN_REISSUE_SUCCESS.getMessage());
    }

}
