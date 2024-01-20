package com.sparta.ten.accounts.dto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccountDtoMapper {
    AccountDtoMapper INSTANCE = Mappers.getMapper(AccountDtoMapper.class);

    AccountDto signupDto(AccountDto.Signup dto);

    AccountDto loginRequestDto(AccountDto.LoginRequest dto);

    AccountDto loginResponseDto(AccountDto.LoginResponse dto);


}
