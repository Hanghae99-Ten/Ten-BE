package com.sparta.ten.plans.repository;

import com.sparta.ten.plans.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findPostById(Long postId);
}
