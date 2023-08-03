package com.sparta.ten.account.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
//    Optional<Account> findByAccount(String account);
    Optional<Account> findByAccountName(String accountName);
}
