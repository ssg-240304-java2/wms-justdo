package com.justdo.fruitfruit.model.service;

import com.justdo.fruitfruit.controller.InputReader;
import com.justdo.fruitfruit.controller.InputReaderFactory;
import com.justdo.fruitfruit.model.dao.UserMapper;
import com.justdo.fruitfruit.model.dto.UserDTO;
import org.apache.ibatis.session.SqlSession;

import static com.justdo.fruitfruit.common.MyBatisTemplate.getSqlSession;

public class CommonService {

    /***
     * 사용자들의 로그인처리하는 함수
     * @param userDTO 입력받은 회원정보
     * @return 일치하는 회원계정을 반환
     *         계정이없을경우 null값 반환
     */
    public UserDTO login(UserDTO userDTO) {
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserDTO result = userMapper.login(userDTO);
        sqlSession.close();
        return result;
    }

    private String id;

    /**
     * 사용자들의 로그인처리하는 함수
     * @param id 입력한 아이디
     * @param password 입력한 패스워드
     * @return 로그인한 계정아이디를 반환
     *         계정이없을경우 null값 반환
     * */
    public String Login(String id,String password){
        return null;
    }

    public String getId() {
        return this.id;
    }
}
