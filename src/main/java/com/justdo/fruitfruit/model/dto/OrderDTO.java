package com.justdo.fruitfruit.model.dto;

import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class OrderDTO {
    private Integer orderSeq;
    private Integer userSeq;
    private Integer companySeq;
    private Integer totalPrice;
    private Integer sta;
    private Timestamp registerDate;
    private Timestamp updateDate;
}
