package com.sparta.ten.accounts.service;

import com.sparta.ten.accounts.domain.Account;
import com.sparta.ten.accounts.domain.AccountRoleEnum;
import com.sparta.ten.accounts.dto.AccountDto;
import com.sparta.ten.accounts.dto.AccountDtoMapper;
import com.sparta.ten.accounts.repository.AccountRepository;
import com.sparta.ten.jwt.JwtUtil;
import com.sparta.ten.util.StatusResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

import static com.sparta.ten.exception.message.SuccessMsg.SIGN_UP_SUCCESS;

@Service
@Validated
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public StatusResponseDto<?> signup(@Valid AccountDto.Signup signup) {
        if(!signup.getPassword().equals(signup.getPasswordCheck())) {
            throw new IllegalArgumentException("패스워드가 틀렸습니다.");
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
                return StatusResponseDto.toResponseEntity(SIGN_UP_SUCCESS);
            }
            throw new IllegalArgumentException("이미 존재하는 사용자입니다.");
        }

        Account account = new Account(email, password, nickName);
        accountRepository.save(account);
        return StatusResponseDto.toResponseEntity(SIGN_UP_SUCCESS);

    }

    public StatusResponseDto<?> login(AccountDto.LoginRequest loginRequest, HttpServletResponse response) {
        String accountUserId = loginRequest.getAccountUserId();
        String password = loginRequest.getPassword();

        Account account = accountRepository.findByAccountUserId(accountUserId).orElseThrow(
                () -> new IllegalArgumentException("존재하지 않는 사용자입니다.")
        );

        if(!passwordEncoder.matches(password, account.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
        }


        response.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(account.getAccountUserId(), AccountRoleEnum.USER));

        return StatusResponseDto.toAlldataResponseEntity(new AccountDto.LoginResponse(account));


    }
}
