package com.justdo.fruitfruit.model.dao;

import com.justdo.fruitfruit.model.dto.GradeDTO;
import com.justdo.fruitfruit.model.dto.ProductDTO;
import com.justdo.fruitfruit.model.dto.SectorDTO;

import java.util.List;

public interface WarehouseMapper {

    List<ProductDTO> findByStatus(int status);

    List<GradeDTO> findByCategorySeq(int categorySeq);

    List<SectorDTO> findByProductAmount(int productAmount);

    int updateProductData(List<ProductDTO> productDTOS);

    int insertProductDate(List<ProductDTO> productDTOS);

    int updateSectorData(List<ProductDTO> productDTOS);
}
