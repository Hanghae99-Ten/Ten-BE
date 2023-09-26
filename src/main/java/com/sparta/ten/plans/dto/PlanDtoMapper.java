package com.sparta.ten.plans.dto;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PlanDtoMapper {

    PlanDtoMapper INSTANCE = Mappers.getMapper(PlanDtoMapper.class);
}
