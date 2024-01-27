package com.sparta.ten.accounts.repository;

import com.sparta.ten.accounts.domain.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByAccountUserId(String accountUserId);
}
