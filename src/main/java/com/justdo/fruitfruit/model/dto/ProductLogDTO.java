package com.justdo.fruitfruit.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductLogDTO {
    private int logSeq;
    private int productSeq;
    private int status;
    private int logAmount;
    private String productName;
    private String sectorName;
    private String categoryName;
    private Timestamp registerDate;
}
