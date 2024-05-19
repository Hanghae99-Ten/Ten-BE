package com.sparta.ten.plans.controller;

import com.sparta.ten.plans.dto.PostDto;
import com.sparta.ten.plans.services.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
@Tag(name = "11.[계획: post] 게시물 정보 api")
public class PostController {

    private final PostService postService;

    @Operation(summary = "게시물 목록 조회", description = "게시물 목록")
    @GetMapping("")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "게시물 목록 조회 성공")
    })
    public PostDto.ResponsePostDto getPostList() {
        return postService.getPostList();
    }

    @Operation(summary = "게시물 상세 조회", description = "게시물 상세 조회")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "게시물 상세 조회 성공")
    })    @GetMapping("/{id}")
    public PostDto.ResponsePostDto getPostDetail(@PathVariable("id") Long id) {
        return postService.getPostDetail(id);
    }

    @Operation(summary = "게시물 등록", description = "게시물 등록")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "게시물 등록 성공")
    })    @PostMapping("/simple")
    public PostDto.ResponsePostDto createSimple() {
        return postService.createSimple();
    }

    @Operation(summary = "게시물 등록", description = "게시물 등록")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "게시물 등록 성공")
    })    @PatchMapping("/{id}")
    public PostDto.ResponsePostDto createPost(@RequestBody PostDto.CreatePostDto requestPostDto, @PathVariable Long id) {
        return postService.createPost(requestPostDto, id);
    }

}
