package com.justdo.fruitfruit.model.dao;

import com.justdo.fruitfruit.model.dto.CartDTO;

import java.util.List;
import java.util.Map;

public interface CartMapper {
    int addCart(Map<String, Object> cart);

    List<CartDTO> viewCart(int userSeq);

    int deleteAllCart(int id);

    int modifyQuantity(Map<String, Integer> params);

    int deleteQuantity(Map<String, Integer> params);

    int modifyYN(Map<String, Integer> params);

    int updateOrderSeq(Map<String, Integer> map2);
}
