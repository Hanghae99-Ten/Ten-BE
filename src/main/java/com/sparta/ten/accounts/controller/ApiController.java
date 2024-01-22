//package com.sparta.ten.accounts.controller;
//
//import com.sparta.ten.accounts.dto.TokenDto;
//import com.sparta.ten.accounts.service.TokenService;
//import io.swagger.v3.oas.annotations.Operation;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api")
//public class ApiController {
//
//    private final TokenService tokenService;
//
//    @Operation(summary = "토큰 갱신")
//    @PostMapping("/refreshToken")
//    public ResponseEntity<TokenDto> refreshToken(@RequestBody TokenDto tokenDto) {
//        return ResponseEntity.ok(tokenService.refresh(tokenDto));
//    }
//}
