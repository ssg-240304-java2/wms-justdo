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
@ToString

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

}
