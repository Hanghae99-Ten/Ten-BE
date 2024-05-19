package com.sparta.ten.plans.repository;

import com.sparta.ten.plans.domain.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateRepository extends JpaRepository<Date, Long> {
    Date findDateById(Long dateId);
}
