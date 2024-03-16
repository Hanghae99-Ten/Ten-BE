package com.sparta.ten.reviews.controller;

import com.sparta.ten.reviews.dto.ReviewDto;
import com.sparta.ten.reviews.services.ReviewService;
import com.sparta.ten.util.StatusResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/review")
public class ReviewController {

    private final ReviewService reviewService;

    @Operation(summary = "리뷰 등록", description = "[리뷰 등록] api")
    @PostMapping("/")
    public StatusResponseDto<?> review(@PathVariable(name = "postId") Long postId, @RequestBody ReviewDto.Review review){
        return reviewService.review(postId, review);
    }
}
