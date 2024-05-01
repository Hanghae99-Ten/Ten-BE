package com.sparta.ten.accounts.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@Entity
@NoArgsConstructor
@Table(name = "accountGroupConnect")
public class AccountGroupConnect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private Group group;

    @Column(nullable = false)
    private Boolean isInvited;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private AccountGroupRoleEnum accountGroupRoleEnum;

    @Builder
    public AccountGroupConnect(Long id, Account account, Group group, Boolean isInvited, AccountGroupRoleEnum accountGroupRoleEnum) {
        this.id = id;
        this.account = account;
        this.group = group;
        this.isInvited = isInvited;
        this.accountGroupRoleEnum = accountGroupRoleEnum;
    }
}
