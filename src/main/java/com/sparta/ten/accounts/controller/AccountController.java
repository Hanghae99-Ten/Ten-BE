package com.sparta.ten.accounts.controller;

import com.sparta.ten.accounts.dto.AccountDto;
import com.sparta.ten.accounts.service.AccountService;
import com.sparta.ten.util.StatusResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountController {

    private final AccountService accountService;
    @PostMapping("/signup")
    public StatusResponseDto<?> signup(@RequestBody @Valid AccountDto.Signup signup) {
        return accountService.signup(signup);
    }



    @PostMapping("/login")
    public StatusResponseDto<?> login(@RequestBody AccountDto.LoginRequest loginRequest, HttpServletResponse response) {
        return accountService.login(loginRequest, response);
    }


}
