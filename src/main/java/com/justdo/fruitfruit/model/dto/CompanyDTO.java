package com.justdo.fruitfruit.model.dto;

import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CompanyDTO {
    private int companySeq;
    private int userSeq;
    private String companyName;
    private String companyPhone;
    private String companyNum;
    private String companyAddress;
    private Timestamp registerDate;

    @Override
    public String toString() {
        return "[회사 번호] " + companySeq + " | "+
                "[회원 번호] " + userSeq + " | "+
                "[회사 이름] " + companyName + " " +
                "[회사 전화번호] " + companyPhone + " "+
                "[사업자 번호] " + companyNum + " "+
                "[회사 주소] " + companyAddress + " " +
                "[회사 정보 등록일] " + registerDate;
    }
}