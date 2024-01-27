package com.sparta.ten.accounts.dto;

import lombok.Getter;

@Getter
public class ResponseDto {
    private String name;
    private int age;

    public ResponseDto(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
