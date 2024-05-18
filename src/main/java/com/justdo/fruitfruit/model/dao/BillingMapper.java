package com.justdo.fruitfruit.model.dao;

import com.justdo.fruitfruit.model.dto.OrderDTO;

import java.util.List;
import java.util.Map;

public interface BillingMapper {
    List<OrderDTO> BillingAmount(Map<String, String> criteria);
}
