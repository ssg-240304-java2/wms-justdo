package com.justdo.fruitfruit.common.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Auth {
    SYSADMIN("시스템관리자"),
    WAREHOUSEADMIN("창고관리자"),
    CONSUMER("구매자"),
    SELLER("판매자");

    @Getter
    final String auth;
}
