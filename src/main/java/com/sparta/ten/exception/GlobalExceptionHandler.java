package com.sparta.ten.exception;

import com.sparta.ten.exception.message.ErrorMsg;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import com.sparta.ten.util.StatusResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {CustomException.class})
    protected ResponseEntity<StatusResponseDto.Error> handleCustomException(CustomException e) {
        log.error("handleCustomException throw CustomException : {}", e.getErrorMsg());
        return ResponseEntity.status(e.getErrorMsg().getHttpStatus())
                .body(new StatusResponseDto.Error(e.getErrorMsg().getHttpStatus().value(), e.getErrorMsg().getMessage()));


    }

    //정규식
    @ExceptionHandler({BindException.class})
    public StatusResponseDto<?> bindException(BindException ex) {
        return StatusResponseDto.toAllExceptionResponseEntity(HttpStatus.BAD_REQUEST,
                ex.getFieldError().getDefaultMessage());
    }

//    //토큰 없을시
//    @ExceptionHandler({MissingRequestHeaderException.class})
//    public StatusResponseDto<?> missingRequestHeaderException(MissingRequestHeaderException ex) {
//        return StatusResponseDto.toAllExceptionResponseEntity(ErrorMsg.NOT_LOGGED_ID);
//    }

    // 500
    @ExceptionHandler({Exception.class})
    public StatusResponseDto<?> handleAll(final Exception ex) {
        return StatusResponseDto.toAllExceptionResponseEntity(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(value = {IOException.class})
    public StatusResponseDto<?> handleIOException(IOException ex) {
        return StatusResponseDto.toAllExceptionResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StatusResponseDto.Error> validationException(MethodArgumentNotValidException e) {
        List<String> errors = e.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
        return ResponseEntity.status(ErrorMsg.InValidException.getHttpStatus())
                .body(new StatusResponseDto.Error<>(400, errors.get(0)));
    }
}
