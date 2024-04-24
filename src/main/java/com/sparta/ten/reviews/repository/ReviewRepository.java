package com.sparta.ten.reviews.repository;

import com.sparta.ten.reviews.domain.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByPostId(Long postId);
}
