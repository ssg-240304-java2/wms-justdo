package com.justdo.fruitfruit.model.dao;

import com.justdo.fruitfruit.model.dto.UserDTO;

import java.util.List;

public interface UserMapper {
    int insertUser(UserDTO userDTO);
    List<UserDTO> selectAllUser();

    UserDTO login(UserDTO userDTO);}
