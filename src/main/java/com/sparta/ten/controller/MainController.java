package com.sparta.ten.controller;

import com.sparta.ten.dto.RedisTestDto;
import com.sparta.ten.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/redis")
public class MainController {

    private final RedisService redisService;

    @PostMapping("")
    public boolean create(@RequestBody RedisTestDto redisTestDto) {
        redisService.setValues(redisTestDto.getKey(), redisTestDto.getValue());
        return true;
    }

    @GetMapping("")
    public String read(@RequestParam String key) {

        return redisService.getValues(key);
    }
}
