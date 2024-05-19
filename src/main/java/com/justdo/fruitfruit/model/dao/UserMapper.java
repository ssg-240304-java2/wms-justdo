package com.justdo.fruitfruit.model.dao;

import com.justdo.fruitfruit.model.dto.CompanyDTO;
import com.justdo.fruitfruit.model.dto.UserDTO;

public interface UserMapper {
    int insertUser(UserDTO userDTO);
    UserDTO login(UserDTO userDTO);
    UserDTO findConsumerId(UserDTO userDTO);
    UserDTO findSellerId(CompanyDTO companyDTO);
}
