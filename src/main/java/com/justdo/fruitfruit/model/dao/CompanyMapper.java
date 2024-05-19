package com.justdo.fruitfruit.model.dao;

import com.justdo.fruitfruit.model.dto.CompanyDTO;

public interface CompanyMapper {
    int insertCompany(CompanyDTO companyDTO);

    int checkUserSeqExists(int userSeq);
}
