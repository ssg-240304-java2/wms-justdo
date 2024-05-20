package com.justdo.fruitfruit.model.dao;

import com.justdo.fruitfruit.model.dto.CategoryDTO;
import com.justdo.fruitfruit.model.dto.ProductDTO;

import java.util.List;

public interface ProductMapper {
List<ProductDTO> selectAllProduct(int userSeq);
    int registerProduct(ProductDTO product);

    int modifyProduct(ProductDTO product);

    int deleteProduct(int productSeq);

    List<ProductDTO> selectAllProductByCategory(int categoryNum);

    List<ProductDTO> selectAllProductByConsumer();
    String productName(Integer productSeq);
}
