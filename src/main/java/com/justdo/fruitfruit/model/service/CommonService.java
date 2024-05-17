package com.justdo.fruitfruit.model.service;

import com.justdo.fruitfruit.controller.InputReader;
import com.justdo.fruitfruit.controller.InputReaderFactory;
import com.justdo.fruitfruit.model.dao.UserMapper;
import com.justdo.fruitfruit.model.dto.UserDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

import static com.justdo.fruitfruit.common.MyBatisTemplate.getSqlSession;

public class CommonService {
    private String id;

    private InputReader inputReader = InputReaderFactory.getInputReader();

    /**
     * 사용자들의 로그인처리하는 함수
     * @param id 입력한 아이디
     * @param password 입력한 패스워드
     * @return 로그인한 계정아이디를 반환
     *         계정이없을경우 null값 반환
     * */
    private static final String CHECK_PHONE_NUMBER_HYPHEN = "^[\\d]{11}+$";

    public UserDTO login(UserDTO userDTO) {
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, String> param = new HashMap<>();
        param.put("id", userDTO.getId());
        param.put("password", userDTO.getPassword());

        UserDTO result = userMapper.login(userDTO);
        sqlSession.close();
        return result;
    }
}
