package com.sparta.ten.security;

import com.sparta.ten.accounts.domain.Account;
import com.sparta.ten.accounts.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String accountName) throws UsernameNotFoundException {

        System.out.println("UserDetailsServiceImpl.loadUserByUsername : " + accountName);

        Account user = accountRepository.findByAccountUserId(accountName)
                .orElseThrow(() -> new UsernameNotFoundException("사용자를 찾을 수 없습니다."));
        return new UserDetailsImpl(user, user.getAccountUserId());
    }
}