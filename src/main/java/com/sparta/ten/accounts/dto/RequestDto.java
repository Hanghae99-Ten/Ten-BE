package com.sparta.ten.accounts.dto;

import lombok.Getter;

@Getter
public class RequestDto {
    private String name;
    private int age;

    public RequestDto(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
