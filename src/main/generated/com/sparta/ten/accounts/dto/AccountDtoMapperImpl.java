package com.sparta.ten.accounts.dto;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-22T20:17:09+0900",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class AccountDtoMapperImpl implements AccountDtoMapper {

    @Override
    public AccountDto signupDto(AccountDto.Signup dto) {
        if ( dto == null ) {
            return null;
        }

        AccountDto accountDto = new AccountDto();

        return accountDto;
    }

    @Override
    public AccountDto loginRequestDto(AccountDto.LoginRequest dto) {
        if ( dto == null ) {
            return null;
        }

        AccountDto accountDto = new AccountDto();

        return accountDto;
    }

    @Override
    public AccountDto loginResponseDto(AccountDto.LoginResponse dto) {
        if ( dto == null ) {
            return null;
        }

        AccountDto accountDto = new AccountDto();

        return accountDto;
    }
}
