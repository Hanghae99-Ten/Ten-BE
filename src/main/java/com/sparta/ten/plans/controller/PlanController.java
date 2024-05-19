package com.sparta.ten.plans.controller;

import com.sparta.ten.plans.dto.PlanPorJCreateRequest;
import com.sparta.ten.plans.services.PlanService;
import com.sparta.ten.security.UserDetailsImpl;
import com.sparta.ten.util.StatusResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/plan")
public class PlanController {

    private final PlanService planService;

    @Operation(summary = "plan P/J 선택", description = "[plan P/J 선택] api")
    @PostMapping("/mbti")
    public ResponseEntity<StatusResponseDto<?>> createPlanPorJ(
            @RequestBody PlanPorJCreateRequest planPorJCreateRequest,
            @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity.ok(planService.planPorJCreateRequest(planPorJCreateRequest, userDetails));
    }

//    @Operation(summary = "plan data insert", description = "[plan data insert] api")
//    @PostMapping("/data")
//    public ResponseEntity<StatusResponseDto<?>> createPlanPorJ(
//            @RequestBody PlanPorJCreateRequest planPorJCreateRequest,
//            @AuthenticationPrincipal UserDetailsImpl userDetails) {
//
//    }
}
