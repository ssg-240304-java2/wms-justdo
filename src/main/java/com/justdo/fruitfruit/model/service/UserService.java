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
    public UserDTO findUserId(UserDTO userDTO) {

        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        try {
            UserDTO result = userMapper.findUserId(userDTO);
            return result;
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }

    }

    /***
     * 비밀번호 수정을 처리하는 함수
     * @param userDTO 입력한 아이디, 이름, 휴대폰번호가 일치하는 회원
     * @return 비밀번호 변경 성공시 1 반환
     *         실패시 0 반환
     */
    public int findUserPassword(UserDTO userDTO) {

        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        try {
            int result =userMapper.findUserPassword(userDTO);
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
     * 입력한 아이디, 이름, 휴대폰번호를 갖고있는 유저를 찾는 함수
     * @param userDTO 입력한 아이디, 이름, 휴대폰번호
     * @return 일치하는 회원의 정보
     */
    public UserDTO existUserByInfo(UserDTO userDTO) {
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        try {
            return userMapper.existUserByInfo(userDTO);
        } finally {
            sqlSession.close();
        }
    }

}
