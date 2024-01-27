package com.sparta.ten.accounts.controller;

import com.sparta.ten.accounts.dto.AccountDto;
import com.sparta.ten.accounts.service.AccountService;
import com.sparta.ten.security.UserDetailsImpl;
import com.sparta.ten.util.StatusResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountController {

    private final AccountService accountService;

    @Operation(summary = "회원가입", description = "[회원가입] api")
    @PostMapping("/signup")
    public StatusResponseDto<?> signup(@RequestBody @Valid AccountDto.Signup signup) {
        return accountService.signup(signup);
    }

    @Operation(summary = "일반 로그인", description = "[일반 로그인] api")
    @PostMapping("/login")
    public StatusResponseDto<?> login(@RequestBody AccountDto.LoginRequest loginRequest,
                                      HttpServletResponse response) throws IOException {
        return accountService.login(loginRequest, response);
    }

    //Todo: Redis 적용 후 "[로그아웃] RefreshToken 제거 및 쿠키 삭제" api 추가 예정

    @Operation(summary = "Accress Token 재발급", description = "[AccressToken 만료 시 RefreshToken을 재발급] api / RefreshToken 필요")
    @PostMapping("/reissue")
    public StatusResponseDto<String> reIssueAccessToken(@Parameter(hidden = true) @AuthenticationPrincipal UserDetailsImpl userDetails,
                                                        HttpServletResponse httpServletResponse) throws UnsupportedEncodingException {
        return accountService.reIssueAccessToken(userDetails.getUser(), httpServletResponse);
    }


}
