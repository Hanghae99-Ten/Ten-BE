package com.sparta.ten.exception;

import com.sparta.ten.exception.message.ErrorMsg;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CustomException extends RuntimeException{
    private final ErrorMsg errorMsg;

}
