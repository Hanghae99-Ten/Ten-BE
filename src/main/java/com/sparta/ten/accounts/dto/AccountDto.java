package com.sparta.ten.accounts.dto;

import com.sparta.ten.accounts.domain.Account;
import com.sparta.ten.accounts.domain.AccountRoleEnum;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class AccountDto {

    @Getter
    @Setter
    public static class Signup {
        @Email(message = "이메일 형식으로 입력해주세요.")
        private String accountUserId;

        @NotBlank(message = "비밀번호를 입력해주세요.")
        @Pattern(regexp = "(?=.*?[A-Z])(?=.*?[\\d])(?=.*?[~!@#$%^&*()_+=\\-`]).{8,15}",
                message = "비밀번호는 영문 대문자, 특수기호, 숫자가 적어도 1개 이상씩 포함된 조합이어야 합니다.")
        private String password;

        @NotBlank(message = "비밀번호 확인을 입력해주세요.")
        private String passwordCheck;

        @NotBlank(message = "닉네임을 입력해주세요.")
        private String accountName;
    }

    @Getter
    @Setter
    public static class LoginRequest {

        @Email(message = "이메일 형식으로 입력해주세요.")
        private String accountUserId;

        @NotBlank(message = "비밀번호를 입력해주세요.")
        private String password;

    }

    @Getter
    @Setter
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

        @Comment("일반/관리자")
        private AccountRoleEnum accountRole;

        @Comment("AccessToken")
        private String accessToken;

        @Comment("RefreshToken")
        private String refreshToken;

        public LoginResponse(Account account, String accessToken, String refreshToken) {
            this.id = account.getId();
            this.accountUserId = account.getAccountUserId();
            this.isActive = account.isActive();
            this.accountProfileImage = account.getAccountProfileImage();
            this.accountBackgroundImage = account.getAccountBackgroundImage();
            this.introduce = account.getIntroduce();
            this.accountRole = account.getAccountRole();
            this.accessToken = accessToken;
            this.refreshToken = refreshToken;
        }
    }

    @Getter
    @Setter
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

        @Comment("[카카오] id")
        private Long kakaoId;

        @Comment("[네이버] id")
        private String naverId;

        @Comment("일반/관리자")
        private AccountRoleEnum accountRole;

    }

}
