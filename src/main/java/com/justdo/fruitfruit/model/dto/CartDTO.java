package com.justdo.fruitfruit.model.dto;

import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CartDTO {
    private Integer cartSeq;
    private Integer productSeq;
    private Integer userSeq;
    private Integer orderSeq;
    private Integer companySeq;
    private Integer quantity;
    private Timestamp registerDate;
    private Integer deleteYN;

    public CartDTO(Integer productSeq, Integer userSeq, Integer orderSeq, Integer companySeq, Integer quantity, Timestamp registerDate) {
        this.productSeq = productSeq;
        this.userSeq = userSeq;
        this.orderSeq = orderSeq;
        this.companySeq = companySeq;
        this.quantity = quantity;
        this.registerDate = registerDate;
    }
}
