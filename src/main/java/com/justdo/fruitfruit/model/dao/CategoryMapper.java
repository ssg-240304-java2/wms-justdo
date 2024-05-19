package com.justdo.fruitfruit.model.dao;

import com.justdo.fruitfruit.model.dto.CategoryDTO;

import java.util.List;

public interface CategoryMapper {
    List<CategoryDTO> selectAllCategory();
}
