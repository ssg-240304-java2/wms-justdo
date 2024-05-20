package com.justdo.fruitfruit.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RequestReleaseDTO {
    private int productSeq;
    private int sectorSeq;
    private String productName;
    private String categoryName;
    private int quantity;
    private int productStatus;
}
