package com.justdo.fruitfruit.model.dao;

import com.justdo.fruitfruit.model.dto.UserDTO;

import java.util.List;
import java.util.Map;

public interface SystemMapper {
    List<UserDTO> selectAllUser();

    int updateUser(Map<String, Object> user);

    int deleteUser(int userSeq);
}