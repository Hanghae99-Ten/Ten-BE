package com.sparta.ten.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sparta.ten.exception.message.ErrorMsg;
import com.sparta.ten.exception.message.SuccessMsg;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatusResponseDto<T> {
    private int statusCode;

//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public static <T> StatusResponseDto<T> success(T data) {
        return new StatusResponseDto<>(200,data);
    }

    @Getter
    @AllArgsConstructor
    public static class Error<T> {
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private int statusCode;
        private final String errorMsg;
    }

    public static StatusResponseDto<?> toAllExceptionResponseEntity(HttpStatus httpStatus,String message) {
        return StatusResponseDto.builder()
                .statusCode(httpStatus.value())
                .data(message)
                .build();
    }

    public static ResponseEntity<StatusResponseDto> toExceptionResponseEntity(ErrorMsg exceptionMessage) {
        return ResponseEntity
                .status(exceptionMessage.getHttpStatus())
                .body(StatusResponseDto.builder()
                        .statusCode(exceptionMessage.getHttpStatus().value())
                        .data(exceptionMessage.getMessage())
                        .build()
                );
    }
}
