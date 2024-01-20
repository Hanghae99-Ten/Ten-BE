package com.sparta.ten.accounts.repository;

import com.sparta.ten.accounts.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    //    Optional<Account> findByAccount(String account);

    Optional<Account> findByAccountName(String accountName);

    Optional<Account> findByAccountUserId(String accountUserId);
//    Optional<Account> findById(Long id);
}
