package com.justdo.fruitfruit.common.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Status {
    /**
     * 입고요청 (판매자가 상품을 등록)
     * 입고(창고에 저장된상태) -> 상품리스트에 표시
     * 출고 요청 (구매자가 결제완료한 상태)
     * 출고 완료 (창고관리자가 변경, 구매자에게는 배송중으로 표시)
     * */

    REQUEST_STOCK("입고요청"),
    STOCK("입고"),
    REQUEST_RELEASE("출고요청"),
    RELEASE("출고완료");

    @Getter
    final String status;
}
