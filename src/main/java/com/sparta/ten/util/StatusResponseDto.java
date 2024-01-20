package com.sparta.ten.util;

import com.sparta.ten.exception.message.SuccessMsg;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@NoArgsConstructor
public class StatusResponseDto<T> {
    private int statusCode;
    private T data;

    public StatusResponseDto(int statusCode, T data) {
        this.statusCode = statusCode;
        this.data = data;
    }

    public static StatusResponseDto<?> toResponseEntity(SuccessMsg message) {
        return StatusResponseDto.builder()
                .statusCode(HttpStatus.OK.value())
                .data(message.getDetail())
                .build();
    }

    public static <T> StatusResponseDto<?> toAlldataResponseEntity(T data) {
        return StatusResponseDto.builder()
                .statusCode(HttpStatus.OK.value())
                .data(data)
                .build();
    }
}
