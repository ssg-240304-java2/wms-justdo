package com.justdo.fruitfruit.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CompanyDTO {
    private Integer companySeq;
    private Integer userSeq;
    private String companyName;
    private String companyPhone;
    private String companyNum;
    private String companyAddress;
}
