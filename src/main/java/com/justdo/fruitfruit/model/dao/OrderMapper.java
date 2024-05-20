package com.justdo.fruitfruit.model.dao;

import com.justdo.fruitfruit.model.dto.OrderDTO;

import java.util.List;
import java.util.Map;

public interface OrderMapper {
    int insertOrder(Map<String, Integer> params);

    List<OrderDTO> allOrder(int userSeq);

    int maxSeq();
}
