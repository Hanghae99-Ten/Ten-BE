package com.sparta.ten.plans.domain;

import com.sparta.ten.commons.domain.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends BaseRepository<Plan, Long> {
}
