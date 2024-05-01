package com.sparta.ten.plans.dto;

import com.sparta.ten.accounts.domain.Group;
import com.sparta.ten.plans.domain.Plan;
import com.sparta.ten.plans.domain.PlanMbtiEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PlanMapper {
    PlanMapper INSTANCE = Mappers.getMapper(PlanMapper.class);

    @Mapping(target = "group", source = "group")
    Plan planPorJCreateRequestDtoToEntity(PlanPorJCreateRequest dto, Group group);

    @Mapping(target = "planId", source = "plan.id")
    @Mapping(target = "mbti", source = "plan.mbti")
    PlanPorJCreateResponse entityToPlanProJResponseDto(Plan plan);
}
