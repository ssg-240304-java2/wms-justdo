package com.justdo.fruitfruit.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductLogDTO {
    private Integer logSeq;
    private Integer status;
    private Integer logAmount;
    private Integer productSeq;
}
