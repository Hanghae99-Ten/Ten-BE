package com.sparta.ten.accounts.controller;

import com.sparta.ten.accounts.dto.RequestDto;
import com.sparta.ten.accounts.dto.ResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/test")
    public ResponseDto getTest() {
        RequestDto requestDto = new RequestDto("name", 20);
        return new ResponseDto(requestDto.getName(), requestDto.getAge());
    }
}
