package com.sparta.ten.accounts.service;

import com.sparta.ten.accounts.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    public void authenticateLogin(AccountDto.LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getAccountUserId(), loginRequest.getPassword());
        authenticationManagerBuilder.getObject().authenticate(authenticationToken);
    }
}
