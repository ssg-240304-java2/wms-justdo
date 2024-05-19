package com.justdo.fruitfruit.model.dao;

import com.justdo.fruitfruit.model.dto.CompanyDTO;
import com.justdo.fruitfruit.model.dto.UserDTO;

import java.util.List;

public interface SystemMapper {
    List<UserDTO> getUserList();

    int updateUserInfo(UserDTO user);

    int deleteUserInfo(int user);

    List<CompanyDTO> getSellerList();

    int updateSellerInfo(CompanyDTO company);

    int deleteSellerInfo(int seller);

    List<CompanyDTO> getSellerRequestList();

    int updateSellerAuth(UserDTO authInfo);
}