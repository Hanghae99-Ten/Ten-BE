package com.sparta.ten.plans.services;

import com.sparta.ten.plans.domain.Post;
import com.sparta.ten.plans.dto.PostDto;
import com.sparta.ten.plans.dto.PostDto.ResponsePostDto;
import com.sparta.ten.plans.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;


    public ResponsePostDto getPostList() {
        return null;
    }

    public ResponsePostDto getPostDetail(Long id) {
        Post post = postRepository.findPostById(id);

        ResponsePostDto responsePostDto = new ResponsePostDto();
        responsePostDto.setId(post.getId());
        responsePostDto.setCreatedAt(post.getCreatedAt());
        responsePostDto.setUpdatedAt(post.getUpdatedAt());
        responsePostDto.setTitle(post.getTitle());
        responsePostDto.setContent(post.getContent());
        responsePostDto.setLocation(post.getLocation());
        responsePostDto.setStartAt(post.getStartAt());
        responsePostDto.setEndAt(post.getEndAt());
        responsePostDto.setOrderIndex(post.getOrderIndex());
        responsePostDto.setDate(post.getDate());
        responsePostDto.setMemo(post.getMemo());
        return responsePostDto;
    }

    @Transactional
    public ResponsePostDto createPost(PostDto.CreatePostDto requestPostDto, Long id) {
        Post post = postRepository.findPostById(id);

        if(requestPostDto.getTitle()!= null) {
            post.setTitle(requestPostDto.getTitle());
        }
        if(requestPostDto.getContent()!= null) {
            post.setContent(requestPostDto.getContent());
        }
        if(requestPostDto.getLocation()!= null) {
            post.setLocation(requestPostDto.getLocation());
        }
        if(requestPostDto.getStartAt()!= null) {
            post.setStartAt(requestPostDto.getStartAt());
        }
        if(requestPostDto.getEndAt()!= null) {
            post.setEndAt(requestPostDto.getEndAt());
        }
        if(requestPostDto.getOrderIndex()!= null) {
            post.setOrderIndex(requestPostDto.getOrderIndex());
        }
        if(requestPostDto.getDate()!= null) {
            post.setDate(requestPostDto.getDate());
        }
        if(requestPostDto.getMemo()!= null) {
            post.setMemo(requestPostDto.getMemo());
        }

        postRepository.save(post);

        ResponsePostDto responsePostDto = new ResponsePostDto();
        responsePostDto.setId(post.getId());
        responsePostDto.setCreatedAt(post.getCreatedAt());
        responsePostDto.setUpdatedAt(post.getUpdatedAt());
        responsePostDto.setTitle(post.getTitle());
        responsePostDto.setContent(post.getContent());
        responsePostDto.setLocation(post.getLocation());
        responsePostDto.setStartAt(post.getStartAt());
        responsePostDto.setEndAt(post.getEndAt());
        responsePostDto.setOrderIndex(post.getOrderIndex());
        responsePostDto.setDate(post.getDate());
        responsePostDto.setMemo(post.getMemo());
        return responsePostDto;
    }

    @Transactional
    public ResponsePostDto createSimple() {
        Post post = new Post();
        postRepository.save(post);

        ResponsePostDto responsePostDto = new ResponsePostDto();
        responsePostDto.setId(post.getId());
        responsePostDto.setCreatedAt(post.getCreatedAt());
        responsePostDto.setUpdatedAt(post.getUpdatedAt());
        return responsePostDto;
    }
}
