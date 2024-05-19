package com.justdo.fruitfruit.model.service;

import com.justdo.fruitfruit.model.dao.CompanyMapper;
import com.justdo.fruitfruit.model.dto.CompanyDTO;
import org.apache.ibatis.session.SqlSession;

import static com.justdo.fruitfruit.common.MyBatisTemplate.getSqlSession;

public class CompanyService {
    public int insertCompany(CompanyDTO companyDTO) {
        SqlSession sqlSession = getSqlSession();
        CompanyMapper companyMapper = sqlSession.getMapper(CompanyMapper.class);

        try {
            int result =companyMapper.insertCompany(companyDTO);
            sqlSession.commit();
            return result;
        } catch(Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }
}
