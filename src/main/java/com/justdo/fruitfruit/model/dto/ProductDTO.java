package com.justdo.fruitfruit.model.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductDTO {
    private int productSeq;
    private int categorySeq;
    private int userSeq;
    private String productName;
    private int productPrice;
    private int productStatus;
    private int productAmount;

}