package com.sparta.ten.plans.controller;

import com.sparta.ten.plans.dto.PostDto;
import com.sparta.ten.plans.services.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
@Api(tags = "11.[계획: post] 게시물 정보 api")
public class PostController {

    private final PostService postService;

    @ApiOperation(value = "게시물 목록 조회", notes = "게시물 목록")
    @GetMapping("")
    @ApiResponse(code = 200, message = "게시물 목록 조회 성공", response = PostDto.ResponsePostDto.class)
    public PostDto.ResponsePostDto getPostList() {
        return postService.getPostList();
    }

    @ApiOperation(value = "게시물 상세 조회", notes = "게시물 상세 조회")
    @GetMapping("/{id}")
    @ApiResponse(code = 200, message = "게시물 상세 조회 성공", response = PostDto.ResponsePostDto.class)
    public PostDto.ResponsePostDto getPostDetail(@PathVariable("id") Long id) {
        return postService.getPostDetail(id);
    }

    @ApiOperation(value = "게시물 등록", notes = "게시물 등록")
    @PostMapping("/simple")
    @ApiResponse(code = 200, message = "게시물 등록 성공", response = PostDto.ResponsePostDto.class)
    public PostDto.ResponsePostDto createSimple() {
        return postService.createSimple();
    }

    @ApiOperation(value = "게시물 등록", notes = "게시물 등록")
    @PatchMapping("/{id}")
    @ApiResponse(code = 200, message = "게시물 등록 성공", response = PostDto.ResponsePostDto.class)
    public PostDto.ResponsePostDto createPost(@RequestBody PostDto.CreatePostDto requestPostDto, @PathVariable Long id) {
        return postService.createPost(requestPostDto, id);
    }

}
