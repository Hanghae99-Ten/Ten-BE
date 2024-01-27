//package com.sparta.ten.accounts.service;
//
//import com.sparta.ten.accounts.domain.Account;
//import com.sparta.ten.accounts.domain.RefreshToken;
//import com.sparta.ten.accounts.dto.AccountDto;
//import com.sparta.ten.accounts.dto.TokenDto;
//import com.sparta.ten.accounts.repository.AccountRepository;
//import com.sparta.ten.accounts.repository.RefreshTokenRepository;
//import com.sparta.ten.jwt.JwtUtil;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class TokenService {
//    private final JwtUtil jwtUtil;
//    private final RefreshTokenRepository refreshTokenRepository;
//    private final AccountRepository accountRepository;
//
////    public TokenDto createToken(AccountDto.LoginRequest) {
////
////    }
//
//    public  TokenDto refresh(TokenDto tokenDto) {
//        if(!jwtUtil.validateToken(tokenDto.getRefreshToken())) {
//            throw new RuntimeException("Refresh Token이 유효하지 않습니다.");
//        }
//        Authentication authentication = jwtUtil.getAuthentication(tokenDto.getAccessToken());
//
//        RefreshToken refreshToken = refreshTokenRepository.findByAccountUserId(accountRepository.findByAccountUserId(authentication.getName()).get().getAccountUserId()).orElseThrow(
//                () -> new RuntimeException("로그아웃 된 사용자입니다.")
//        );
//
//        if(!refreshToken.getRefreshToken().equals(tokenDto.getRefreshToken())) {
//            throw new RuntimeException("Refresh Token이 일치하지 않습니다.");
//        }
//
//        Account account = accountRepository.findByAccountUserId(refreshToken.getAccountUserId()).orElseThrow(
//                () -> new RuntimeException("존재하지 않는 계정입니다.")
//        );
//        TokenDto newTokenDto = jwtUtil.createTokenDTO(account.getAccountUserId(), account.getAccountRole());
//
//        RefreshToken newRefreshToken = refreshToken.updateToken(tokenDto.getRefreshToken());
//        refreshTokenRepository.save(newRefreshToken);
//
//        return newTokenDto; //Todo: response 바꾸기
//    }
//}
