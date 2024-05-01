package com.sparta.ten.plans.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PlanPorJCreateResponse {
    private Long planId;
    private String mbti;

    @Builder
    public PlanPorJCreateResponse(Long planId, String mbti) {
        this.planId = planId;
        this.mbti = mbti;
    }
}
