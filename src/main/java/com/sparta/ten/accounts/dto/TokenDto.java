package com.sparta.ten.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Duration;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenDto {
    private String tokenType;
    private String accessToken;
    private String refreshToken;
    private Duration duration;
}
