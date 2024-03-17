package com.sparta.ten.exception.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessMsg {
    SIGN_UP_SUCCESS(HttpStatus.CREATED, "회원가입 완료"),
    TOKEN_REISSUE_SUCCESS(HttpStatus.CREATED, "토큰 재발급 완료");

    private final HttpStatus httpStatus;
    private final String message;
}
