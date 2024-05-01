package com.sparta.ten.accounts.repository;

import com.sparta.ten.accounts.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
