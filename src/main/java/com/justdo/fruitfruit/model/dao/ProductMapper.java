package com.justdo.fruitfruit.model.dao;

import com.justdo.fruitfruit.model.dto.CategoryDTO;
import com.justdo.fruitfruit.model.dto.ProductDTO;

import java.util.List;

public interface ProductMapper {
    List<ProductDTO> selectAllProduct(int userSeq);
    int registerProdCategory(CategoryDTO category);

    int modifyProdCategory(CategoryDTO category);
    int registerProduct(ProductDTO product);

    int modifyProduct(ProductDTO product);

    int deleteProduct(String productSeq);
}
