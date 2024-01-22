package com.sparta.ten.accounts.domain;

import lombok.Getter;

@Getter
public enum TokenState {
    VALID,
    EXPIRED,
    INVALID
}
