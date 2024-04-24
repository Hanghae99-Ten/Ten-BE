package com.sparta.ten.reviews.services;

import com.sparta.ten.plans.domain.Post;
import com.sparta.ten.plans.repository.PostRepository;
import com.sparta.ten.reviews.dto.ReviewDto;
import com.sparta.ten.util.StatusResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final PostRepository postRepository;
    public StatusResponseDto<?> review(Long postId, ReviewDto.Review review) {

        Post post = postRepository.findPostById(postId);
//        post.get
        return null;

    }
}
