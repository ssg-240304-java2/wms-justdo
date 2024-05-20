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
    private String sectorName;
    private Integer gradeSeq;
    private String gradeName;
    private int userSeq;
    private String name;
    private String productName;
    private int productPrice;
    private int productStatus;
    private Timestamp registerDate;
    private Timestamp expirationDate;
    private Timestamp updateDate;
    private int productAmount;
    private double productWeight;
    private String notificationType;

    public String getProductStatusDescription(){
        switch (productStatus) {
            case 1:
                return Status.REQUEST_STOCK.getStatus();
            case 2:
                return Status.STOCK.getStatus();
            case 3:
                return Status.REQUEST_RELEASE.getStatus();
            case 4:
                return Status.RELEASE.getStatus();
            default:
                return "알 수 없음";
        }
    }

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
                ", 진행 상황 = " + getProductStatusDescription() +
                ", 등록일 = " + registerDate +
                ", 수정일 = " + updateDate +
                ", 수량 = " + productAmount +
                ", 무게 = " + productWeight +
                ']';
    }

}
