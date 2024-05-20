package com.justdo.fruitfruit.model.dao;

import com.justdo.fruitfruit.model.dto.*;

import java.util.List;
import java.util.Map;

public interface SystemMapper {
    List<UserDTO> getUserList();

    int updateUserInfo(UserDTO user);

    int deleteUserInfo(int user);

    List<CompanyDTO> getSellerList();

    int updateSellerInfo(CompanyDTO company);

    int deleteSellerInfo(int seller);

    List<CompanyDTO> getSellerRequestList();

    int updateSellerAuth(UserDTO authInfo);

    List<ProductDTO> getProductAllList();

    List<ProductDTO> getProductSaleList();

    int deleteProductInfo(int product);

    List<OrderDTO> getOrderAllList();

    List<OrderDTO> getOrderOnShipping();

    List<SalesDTO> getSalesMonthBySeller(String month);

    List<SalesDTO> getSalesYearBySeller(String year);
}