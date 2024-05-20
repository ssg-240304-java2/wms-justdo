package com.justdo.fruitfruit.model.service;

import com.justdo.fruitfruit.model.dao.CompanyMapper;
import com.justdo.fruitfruit.model.dto.CompanyDTO;
import org.apache.ibatis.session.SqlSession;

import static com.justdo.fruitfruit.common.MyBatisTemplate.getSqlSession;

public class CompanyService {

    /***
     * 판매자 등록을 처리하는 함수
     * @param companyDTO 입력한 회사정보
     * @return 추가된 컬럼개수를 반환
     *         없을경우 0 반환
     */
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

    /***
     * 이미 있는 회원인지 검사하는 메서드
     * @param userSeq 회원번호
     * @return 있을경우 true
     *         없을경우 false 반환
     */
    public boolean checkUserSeqExists(int userSeq) {
        SqlSession sqlSession = getSqlSession();
        CompanyMapper companyMapper = sqlSession.getMapper(CompanyMapper.class);
        int count = companyMapper.checkUserSeqExists(userSeq);
        return count > 0;
    }
}
