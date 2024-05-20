package com.justdo.fruitfruit.model.dao;

import com.justdo.fruitfruit.model.dto.UserDTO;

import java.util.Map;

public interface UserMapper {
    int insertUser(UserDTO userDTO);
    UserDTO login(UserDTO userDTO);
    UserDTO findUserId(UserDTO userDTO);
    int findUserPassword(UserDTO userDTO);

    Integer searchUser(String id);
    UserDTO existUserByInfo(UserDTO userDTO);
}
