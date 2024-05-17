package com.justdo.fruitfruit.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {
    private Integer productSeq;
    private Integer categorySeq;
    private Integer sectorSeq;
    private Integer gradeSeq;
    private String productName;
    private Integer productPrice;
    private Integer productStatus;
    private Integer productAmount;
    private Integer userSeq;
}
