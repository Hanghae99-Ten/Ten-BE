package com.sparta.ten.accounts.dto;

import com.sparta.ten.accounts.domain.Account;
import com.sparta.ten.accounts.domain.AccountMbtiEnum;
import com.sparta.ten.accounts.domain.AccountRoleEnum;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AccountDto {

    @Getter
    @Setter
    @ApiOperation("AccountDto.Signup")
    public static class Signup {
        @Email(message = "이메일 형식으로 입력해주세요.")
        private String accountUserId;

        @NotBlank(message = "비밀번호를 입력해주세요.")
        private String password;

        @NotBlank(message = "비밀번호 확인을 입력해주세요.")
        private String passwordCheck;

        @NotBlank(message = "닉네임을 입력해주세요.")
        private String accountName;
    }

    @Getter
    @Setter
    @ApiOperation("AccountDto.LoginRequest")
    public static class LoginRequest {

        @Email(message = "이메일 형식으로 입력해주세요.")
        private String accountUserId;

        @NotBlank(message = "비밀번호를 입력해주세요.")
        private String password;

    }

    @Getter
    @Setter
    @ApiOperation("AccountDto.LoginResponse")
    public static class LoginResponse {

        @Comment("[DB] id")
        private Long id;

        @Comment("[이메일] id")
        private String accountUserId;

        @Comment("로그인 여부")
        private boolean isActive;

        @Comment("프로필 이미지")
        private String accountProfileImage;

        @Comment("프로필 배경 이미지")
        private String accountBackgroundImage;

        @Comment("자기소개")
        private String introduce;

        @Comment("mbti")
        private AccountMbtiEnum mbti;

        @Comment("일반/관리자")
        private AccountRoleEnum accountRole;

        public LoginResponse(Account account) {
            this.id = account.getId();
            this.accountUserId = account.getAccountUserId();
            this.isActive = account.isActive();
            this.accountProfileImage = account.getAccountProfileImage();
            this.accountBackgroundImage = account.getAccountBackgroundImage();
            this.introduce = account.getIntroduce();
            this.mbti = account.getMbti();
            this.accountRole = account.getAccountRole();
        }
    }

    @Getter
    @Setter
    @ApiOperation("AccountDto.Simple")
    public static class Simple {
        @Comment("[DB] id")
        private Long id;

        @Comment("[이메일] id")
        private String accountUserId;

        @Comment("로그인 여부")
        private boolean isActive;

        @Comment("프로필 이미지")
        private String accountProfileImage;

        @Comment("프로필 배경 이미지")
        private String accountBackgroundImage;

        @Comment("자기소개")
        private String introduce;

        @Comment("mbti")
        private AccountMbtiEnum mbti;

        @Comment("[카카오] id")
        private Long kakaoId;

        @Comment("[네이버] id")
        private String naverId;

        @Comment("일반/관리자")
        private AccountRoleEnum accountRole;

    }

}
