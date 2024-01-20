package com.sparta.ten.accounts.domain;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email// @가 없거나 영문이 아닌 한글인 경우, 특수기호는 오류
    @Column(nullable = false, unique = true)
    private String accountUserId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String accountName;

    @Column(nullable = false)
    private boolean isActive;

    @Column(nullable = true)
    private String accountProfileImage;

    @Column(nullable = true)
    private String accountBackgroundImage;

    @Column(nullable = true)
    private String introduce;

    @Column(nullable = true)
    private AccountMbtiEnum mbti;

    @Column(unique = true)
    private Long kakaoId;

    @Column(unique = true)
    private String naverId;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private AccountRoleEnum accountRole;


//    public Member(SignUpRequestDto requestDto, String password){
//        this.membername = requestDto.getMembername();
//        this.nickname = requestDto.getNickname();
//        this.email = requestDto.getEmail();
//        this.password = password;
//        this.profileImageUrl = "https://my-aws-bucket-image.s3.ap-northeast-2.amazonaws.com/%E1%84%83%E1%85%A2%E1%84%8C%E1%85%B5+161.png";
//        this.role = MemberRoleEnum.USER;
//    }
//
//    public void update(MemberRequestDto requestDto, String profileImageUrl){
//        this.nickname = requestDto.getNickname();
//        this.memberInfo = requestDto.getMemberInfo();
//        this.profileImageUrl = profileImageUrl;
//    }
//
//    //네이버 회원 정보
//    @Builder
//    public Member(String naverId, String email, String profileImageUrl, String password, String nickname, String membername){
//        this.membername = membername;
//        this.email = email;
//        this.profileImageUrl = profileImageUrl;
//        this.password = password;
//        this.nickname = nickname;
//        this.naverId = naverId;
//        this.role = MemberRoleEnum.USER;
//    }
//
//    //카카오 회원 정보
//    public Member(String nickname, String profileImageUrl, String password, String email, Long kakaoId, String membername){
//        this.membername = membername;
//        this.email = email;
//        this.password = password;
//        this.profileImageUrl = profileImageUrl;
//        this.nickname = nickname;
//        this.kakaoId = kakaoId;
//        this.role = MemberRoleEnum.USER;
//
//    }


    public Account(String accountUserId, String password, String accountName) {
        this.accountUserId = accountUserId;
        this.password = password;
        this.accountName = accountName;
        this.isActive = false;
        this.accountRole = AccountRoleEnum.USER;
    }
}