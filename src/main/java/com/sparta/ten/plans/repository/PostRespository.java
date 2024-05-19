package com.sparta.ten.plans.repository;

import com.sparta.ten.plans.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRespository extends JpaRepository<Post, Long> {
    Post findPostById(Long postId);
}
