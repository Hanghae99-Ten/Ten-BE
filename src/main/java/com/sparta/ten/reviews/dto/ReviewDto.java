package com.sparta.ten.reviews.dto;

import javax.validation.constraints.NotBlank;

public class ReviewDto {

    public static class Review{
        @NotBlank
        private Long userId;

        @NotBlank
        private String content;

        @NotBlank
        private float score;

        @NotBlank
        private int price;
    }
}
