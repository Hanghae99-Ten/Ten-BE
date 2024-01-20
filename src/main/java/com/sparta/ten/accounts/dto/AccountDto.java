package com.sparta.ten.accounts.dto;

import com.sparta.ten.accounts.domain.Account;
import com.sparta.ten.accounts.domain.AccountMbtiEnum;
import com.sparta.ten.accounts.domain.AccountRoleEnum;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;

public class AccountDto {

    @Getter
    @Setter
    @ApiOperation("AccountDto.Signup")
    public static class Signup {
        @Email
        private String accountUserId;

        private String password;

        private String passwordCheck;

        private String accountName;
    }

    @Getter
    @Setter
    @ApiOperation("AccountDto.LoginRequest")
    public static class LoginRequest {
        private String accountUserId;

        private String password;

    }

    @Getter
    @Setter
    @ApiOperation("AccountDto.LoginResponse")
    public static class LoginResponse {
        private Long id;

        private String accountUserId;

        private boolean isActive;

        private String accountProfileImage;

        private String accountBackgroundImage;

        private String introduce;

        private AccountMbtiEnum mbti;

        private Long kakaoId;

        private String naverId;

        private AccountRoleEnum accountRole;

        public LoginResponse(Account account) {
            this.id = account.getId();
            this.accountUserId = account.getAccountUserId();
            this.isActive = account.isActive();
            this.accountProfileImage = account.getAccountProfileImage();
            this.accountBackgroundImage = account.getAccountBackgroundImage();
            this.introduce = account.getIntroduce();
            this.mbti = account.getMbti();
            this.kakaoId = account.getKakaoId();
            this.naverId = account.getNaverId();
            this.accountRole = account.getAccountRole();
        }
    }

    @Getter
    @Setter
    @ApiOperation("AccountDto.Simple")
    public static class Simple {
        private Long id;

        private String accountUserId;

        private String accountName;

        private boolean isActive;

        private String accountProfileImage;

        private String accountBackgroundImage;

        private String introduce;

        private AccountMbtiEnum mbti;

        private Long kakaoId;

        private String naverId;

        private AccountRoleEnum accountRole;

    }

}
