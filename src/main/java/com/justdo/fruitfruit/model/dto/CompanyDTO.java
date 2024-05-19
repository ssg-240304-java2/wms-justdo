package com.justdo.fruitfruit.model.dto;

import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CompanyDTO {
    private int companySeq;
    private int userSeq;
    private String companyName;
    private String companyPhone;
    private String companyNum;
    private String companyAddress;
    private Timestamp registerDate;
}