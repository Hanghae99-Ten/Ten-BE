package com.sparta.ten.plans.dto;

import com.sparta.ten.plans.domain.Plan;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PlanDtoMapper {

    PlanDtoMapper INSTANCE = Mappers.getMapper(PlanDtoMapper.class);

    Plan dtoToEntity(PlanDto.Create dto);

    @Named("E2Response")
    PlanDto.Response entityToResponse(Plan entity);

    void map(PlanDto.Create dto, @MappingTarget Plan entity);
}
