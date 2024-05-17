package com.justdo.fruitfruit.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDTO {
    private Integer orderSeq;
    private Integer userSeq;
    private Integer totalPrice;
    private Integer status;
    private Integer companySeq;
}
