package com.justdo.fruitfruit.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.DecimalFormat;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SalesDTO {
    private int companySeq;
    private String companyName;
    private int totalPrice;
    private int totalSales; // 매출 조회 시 집계 함수 SUM을 받는 필드

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("###,###");
        String formattedTotalSales = df.format(totalSales);

        return "판매자 번호: " + companySeq + "\n" +
                "판매자 이름: " + companyName + "\n" +
                "판매자 매출: " + formattedTotalSales + "원"
                ;
    }
}