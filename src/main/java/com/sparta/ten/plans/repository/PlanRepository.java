package com.sparta.ten.plans.repository;

import com.sparta.ten.commons.domain.BaseRepository;
import com.sparta.ten.plans.domain.Plan;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends BaseRepository<Plan, Long> {
}
