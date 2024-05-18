package com.justdo.fruitfruit.model.dto;

import lombok.*;

import java.sql.Timestamp;
/**
 * Product테이블 DTO
 * */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class ProductDTO {

    private int productSeq;
    private int categorySeq;
    private String categoryName;
    private Integer sectorSeq;
    private Integer gradeSeq;
    private int userSeq;
    private String productName;
    private int productPrice;
    private int productStatus;
    private Timestamp registerDate;
    private Timestamp updateDate;
    private int productAmount;
    private double productWeight;

    @Override
    public String toString() {
        return "조회 -> [" +
                "물품 번호 = " + productSeq +
                ", 카테고리 번호 = " + categorySeq +
                ", 카테고리 = '" + categoryName + '\'' +
                ", 저장 섹터 = " + sectorSeq +
                ", 등급 = " + gradeSeq +
                ", 유저번호 = " + userSeq +
                ", 상품 이름 = '" + productName + '\'' +
                ", 가격 = " + productPrice +
                ", 진행 상황 = " + productStatus +
                ", 등록일 = " + registerDate +
                ", 수정일 = " + updateDate +
                ", 수량 = " + productAmount +
                ", 무게 = " + productWeight +
                ']';
    }
}
