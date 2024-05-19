package com.justdo.fruitfruit.model.service;

import com.justdo.fruitfruit.model.dao.UserMapper;
import com.justdo.fruitfruit.model.dto.CompanyDTO;
import com.justdo.fruitfruit.model.dto.UserDTO;
import org.apache.ibatis.session.SqlSession;

import static com.justdo.fruitfruit.common.MyBatisTemplate.getSqlSession;

public class UserService {

    /***
     * 회원가입을 처리하는 함수
     * @param userDTO 입력한 회원정보
     * @return 추가된 컬럼개수를 반환
     *         없을경우 0 반환
     */
    public int insertUser(UserDTO userDTO) {

        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        try {
            int result =userMapper.insertUser(userDTO);
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
     * 구매자 아이디 찾기를 처리하는 함수
     * @param userDTO 입력한 회원의 이름, 핸드폰번호
     * @return 일치하는 회원의 아이디
     */
    public UserDTO findConsumerId(UserDTO userDTO) {

        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        try {
            UserDTO result = userMapper.findConsumerId(userDTO);
            return result;
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }

    }

    /***
     * 판매자 아이디 찾기를 처리하는 함수
     * @param companyDTO 입력한 회사의 이름, 회사전화번호
     * @return 일치하는 판매자 아이디
     */
    public UserDTO findSellerId(CompanyDTO companyDTO) {

        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        try {
            UserDTO result = userMapper.findSellerId(companyDTO);
            return result;
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }

    }

}
