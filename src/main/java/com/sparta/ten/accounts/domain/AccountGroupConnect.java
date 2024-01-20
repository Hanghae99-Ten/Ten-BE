package com.sparta.ten.accounts.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "accountGroupConnect")
public class AccountGroupConnect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Account> accounts = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Group> groups = new HashSet<>();
}
