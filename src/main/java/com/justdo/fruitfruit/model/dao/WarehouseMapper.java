package com.justdo.fruitfruit.model.dao;

import com.justdo.fruitfruit.model.dto.*;

import java.util.List;
import java.util.Map;

public interface WarehouseMapper {

    List<ProductDTO> findByStatus(int status);

    List<GradeDTO> findByCategorySeq(int categorySeq);

    List<SectorDTO> findByProductAmount(int productAmount);

    int updateProductData(List<ProductDTO> productDTOS);

    int insertProductDate(List<ProductDTO> productDTOS);

    int updateSectorData(List<ProductDTO> productDTOS);

    List<ProductDTO> findByStatusAndStock(ProductDTO productDTO);

    int getUserSeq(String id);

    List<ProductDTO> getNotificationProductList(ProductDTO productDTO);

    int insertNotificationProduct(List<NotificationDTO> notificationList);

    List<ProductLogDTO> getProductLogList(Map<String, String> param);

    int updateProductAmount(List<RequestReleaseDTO> productDTOS);

    List<RequestReleaseDTO> getRequestReleaseLit(int status);

    int insertReleaseProductDate(List<RequestReleaseDTO> productDTOS);

    int updateMinusSectorData(List<RequestReleaseDTO> productDTOS);
}
