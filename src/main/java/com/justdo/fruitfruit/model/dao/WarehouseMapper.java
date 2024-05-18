package com.justdo.fruitfruit.model.dao;

import com.justdo.fruitfruit.model.dto.ProductDTO;

import java.util.List;

public interface WarehouseMapper {

    List<ProductDTO> findByStatus(int status);
}
