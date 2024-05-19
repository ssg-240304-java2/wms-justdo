package com.justdo.fruitfruit.model.dao;

import com.justdo.fruitfruit.model.dto.UserDTO;

import java.util.List;

public interface SystemMapper {
    List<UserDTO> getUserList();

    int updateUserInfo(UserDTO user);

    int deleteUserInfo(int userSeq);

}