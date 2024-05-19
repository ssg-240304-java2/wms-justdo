package com.justdo.fruitfruit.model.service;

import com.justdo.fruitfruit.model.dao.SystemMapper;
import com.justdo.fruitfruit.model.dto.UserDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.justdo.fruitfruit.common.MyBatisTemplate.getSqlSession;

public class SystemService {

    private SystemMapper systemMapper;

    public List<UserDTO> getUserList() {
        SqlSession sqlSession = getSqlSession();
        systemMapper = sqlSession.getMapper(SystemMapper.class);
        List<UserDTO> userList = systemMapper.getUserList();

        sqlSession.close();

        return userList;
    }

    public int updateUserInfo(UserDTO user) {
        SqlSession sqlSession = getSqlSession();
        systemMapper = sqlSession.getMapper(SystemMapper.class);

        try {
            int result = systemMapper.updateUserInfo(user);
            sqlSession.commit();

            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public int deleteUserInfo(String userSeq) {
        SqlSession sqlSession = getSqlSession();
        systemMapper = sqlSession.getMapper(SystemMapper.class);

        int user = Integer.parseInt(userSeq);

        try {
            int result = systemMapper.deleteUserInfo(user);
            sqlSession.commit();

            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

}
