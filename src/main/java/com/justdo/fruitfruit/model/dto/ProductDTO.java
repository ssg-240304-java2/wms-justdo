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
    private Timestamp updateDate;
    private int productAmount;
    private double productWeight;

    @Override
    public String toString() {
        return  "productSeq=" + productSeq + '\n' +
                ", categoryName='" + categoryName + '\n' +
                ", productName='" + productName + '\n' +
                ", grade_name ='" + gradeName +'\n' +
                ", productPrice=" + productPrice + '\n' +
                ", productAmount=" + productAmount + '\n' +
                ", productWeight=" + productWeight;
    }

}
