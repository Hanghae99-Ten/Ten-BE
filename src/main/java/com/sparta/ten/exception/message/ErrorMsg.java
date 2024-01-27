package com.sparta.ten.exception.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Getter
@RequiredArgsConstructor
public enum ErrorMsg {
    //400
    TOKEN_SECURITY_EXCEPTION_OR_MALFORMED_JWT_EXCEPTION(HttpStatus.BAD_REQUEST, "Invalid JWT signature, 유효하지 않는 JWT 서명 입니다."),
    TOKEN_EXPIRED_JWT_EXCEPTION(HttpStatus.BAD_REQUEST, "Expired JWT token, 만료된 JWT token 입니다."),
    TOKEN_UNSUPPORTED_JWT_EXCEPTION(HttpStatus.BAD_REQUEST, "Unsupported JWT token, 지원되지 않는 JWT 토큰 입니다."),
    TOKEN_ILLEGAL_ARGUMENT_EXCEPTION(HttpStatus.BAD_REQUEST, "JWT claims is empty, 잘못된 JWT 토큰 입니다."),
    REFRESH_TOKEN_VALID_EXCEPTION(HttpStatus.BAD_REQUEST, "refreshToken이 유효하지 않습니다."),
    NOT_FOUND_REFRESH_TOKEN(HttpStatus.SEE_OTHER, "refreshToken이 존재하지 않습니다."),
    NOT_MATCHED_IP(HttpStatus.SEE_OTHER, "로그인 시점과 Ip가 일치하지 않습니다. 재로그인 해주세요."),
    TOKEN_NEED_REISSUE(HttpStatus.SEE_OTHER, "액세스 토큰이 만료되었습니다. 재발급 해주세요."),
    INVALID_ACCESS_TOKEN(HttpStatus.BAD_REQUEST, "액세스 토큰이 유효하지 않습니다."),
    NOT_MATCH_CHECK_PASSWORD(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다."),
    NOT_MATCH_PASSWORD(HttpStatus.BAD_REQUEST, "비밀번호가 틀렸습니다."),
    InValidException(HttpStatus.BAD_REQUEST, "값이 잘못되었습니다."),

    //401 UNAUTHORIZED : 인증되지 않은 사용자
    NOT_LOGGED_ID(UNAUTHORIZED, "로그인이 되어있지 않습니다."),

    //403 FORBIDDEN : 권한 없음


    //404 NOT_FOUND : Resource 를 찾을 수 없음
    NOT_FOUND_ACCOUNT(HttpStatus.NOT_FOUND, "존재하지 않는 사용자입니다."),

    //409 CONFLICT : Resource 의 현재 상태와 충돌. 보통 중복된 데이터 존재
    DUPLICATE_ACCOUNT_ID(HttpStatus.CONFLICT, "이미 존재하는 이메일입니다.");


    private final HttpStatus httpStatus;
    private final String message;
}
