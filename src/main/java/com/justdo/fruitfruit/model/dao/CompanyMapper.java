package com.justdo.fruitfruit.model.dao;

import com.justdo.fruitfruit.model.dto.CompanyDTO;

import java.util.Map;

public interface CompanyMapper {
    int insertCompany(CompanyDTO companyDTO);

    int checkUserSeqExists(int userSeq);
    Integer searchCom(Map<String, Integer> map);
}
