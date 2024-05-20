package com.justdo.fruitfruit.common.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum NotificationType {

    /**
     * OUTOFSTOCK : 재고가 5개 이하인경우
     * PASSEXPIRATIONDATE : 입고후 14일이 지난경우
     * */
    OUTOFSTOCK("재고부족"),
    PASSEXPIRATIONDATE("유통기한지남");

    @Getter
    final String notificationType;
}
