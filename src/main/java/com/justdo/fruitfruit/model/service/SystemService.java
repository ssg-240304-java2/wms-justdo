package com.justdo.fruitfruit.model.service;

import com.justdo.fruitfruit.model.dao.SystemMapper;
import com.justdo.fruitfruit.model.dto.UserDTO;
import com.justdo.fruitfruit.view.ResultMessage;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.justdo.fruitfruit.common.MyBatisTemplate.getSqlSession;

public class SystemService {

    public List<UserDTO> selectAllUser() {
        SqlSession sqlSession = getSqlSession();
        SystemMapper systemMapper = sqlSession.getMapper(SystemMapper.class);
        List<UserDTO> userList = systemMapper.selectAllUser();

        sqlSession.close();

        return userList;
    }

    public int updateUser(Map<String, Object> user) {
        SqlSession sqlSession = getSqlSession();
        SystemMapper systemMapper = sqlSession.getMapper(SystemMapper.class);

        try {
            int result = systemMapper.updateUser(user);
            sqlSession.commit();

            return result;
        } catch (Exception e) {
            sqlSession.rollback();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    public int deleteUser(int userSeq) {
        SqlSession sqlSession = getSqlSession();
        SystemMapper systemMapper = sqlSession.getMapper(SystemMapper.class);

        try {
            int result = systemMapper.deleteUser(userSeq);
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
