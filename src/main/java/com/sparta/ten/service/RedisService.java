//package com.sparta.ten.service;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Service;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.time.Duration;
//
//@Service
//@RequiredArgsConstructor
//public class RedisService {
//    private final RedisTemplate redisTemplate;
//
//    // 데이터 넣기
//    public void setValues(String key, String value){
//        ValueOperations<String, String> values = redisTemplate.opsForValue();
//        values.set(key, value, Duration.ofMinutes(3)); // 3분 뒤 메모리에서 삭제된다.
//    }
//    // 데이터 가져오기
//    public String getValues(String key){
//        ValueOperations<String, String> values = redisTemplate.opsForValue();
//        String value = values.get(key);
//        if(value == null) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//        }
//        return value;
//    }
//}
