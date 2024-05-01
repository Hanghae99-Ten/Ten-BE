package com.sparta.ten.exception.message;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessMsg {
    /* 200 OK 완료*/

    /* 201 CREATED 생성*/
    SIGN_UP_SUCCESS(HttpStatus.CREATED, "회원가입 완료"),
    TOKEN_REISSUE_SUCCESS(HttpStatus.CREATED, "토큰 재발급 완료"),
    P_OR_J_SELECT_SUCCESS(HttpStatus.CREATED, "P/J 선택 완료");

    private final HttpStatus httpStatus;
    private final String message;
}
