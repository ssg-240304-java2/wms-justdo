package com.justdo.fruitfruit.model.dto;

import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class OrderDTO {
    private Integer orderSeq;
    private Integer userSeq;
    private Integer companySeq;
    private Integer totalPrice;
    private Integer status;
    private Timestamp registerDate;
    private Timestamp updateDate;

    @Override
    public String toString() {
        String statusName;
        if (status == 1) {
            statusName = "입고요청";
        } else if (status == 2) {
            statusName = "입고";
        } else if (status == 3) {
            statusName = "출고요청";
        } else if (status ==4) {
            statusName = "출고완료";
        } else {
            statusName = "unKnown";
        }

        return
                "[주문번호] " + orderSeq + " | " +
                        "[회원번호] " + userSeq + " " +
                        "[회사번호] " + companySeq + " " +
                        "[주문금액] " + totalPrice + " " +
                        "[주문상태] " + statusName + " " +
                        "[등록일] " + registerDate + " " +
                        "[수정일] " + updateDate
                ;
    }
}
