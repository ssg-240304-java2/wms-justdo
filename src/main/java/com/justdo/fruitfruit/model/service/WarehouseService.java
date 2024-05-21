package com.justdo.fruitfruit.model.service;

import com.justdo.fruitfruit.common.constant.Status;
import com.justdo.fruitfruit.model.dao.WarehouseMapper;
import com.justdo.fruitfruit.model.dto.*;
import org.apache.ibatis.session.SqlSession;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import static com.justdo.fruitfruit.common.MyBatisTemplate.getSqlSession;


public class WarehouseService {

    private WarehouseMapper warehouseMapper;

    public List<ProductDTO> getRequestStockList() {

        SqlSession sqlSession = getSqlSession();
        warehouseMapper = sqlSession.getMapper(WarehouseMapper.class);

        int status = Status.REQUEST_STOCK.ordinal()+1;
        List<ProductDTO> requestStockList = warehouseMapper.findByStatus(status);
        sqlSession.close();

        return requestStockList;

    }

    public List<RequestReleaseDTO> getRequestReleaseList() {
        SqlSession sqlSession = getSqlSession();
        warehouseMapper = sqlSession.getMapper(WarehouseMapper.class);

        int status = Status.REQUEST_RELEASE.ordinal()+1;
        List<RequestReleaseDTO> requestReleaseList = warehouseMapper.getRequestReleaseLit(status);
        sqlSession.close();

        return requestReleaseList;
    }

    public List<GradeDTO> getGradeList(int categorySeq) {

        SqlSession sqlSession = getSqlSession();
        warehouseMapper = sqlSession.getMapper(WarehouseMapper.class);

        List<GradeDTO> gradeList = warehouseMapper.findByCategorySeq(categorySeq);
        sqlSession.close();

        return gradeList;
    }

    public List<SectorDTO> getSectorList(int productAmount) {
        SqlSession sqlSession = getSqlSession();
        warehouseMapper = sqlSession.getMapper(WarehouseMapper.class);
        List<SectorDTO> sectorList = warehouseMapper.findByProductAmount(productAmount);
        sqlSession.close();
        return sectorList;
    }

    public boolean addRequestStockList(List<ProductDTO> productDTOS) {
        SqlSession sqlSession = getSqlSession();
        warehouseMapper = sqlSession.getMapper(WarehouseMapper.class);
        int result = warehouseMapper.updateProductData(productDTOS);
        int insertResult = warehouseMapper.insertProductDate(productDTOS);
        int updateSectorResult = warehouseMapper.updateSectorData(productDTOS);
        if(result > 0 && insertResult>0 && updateSectorResult>0){
            sqlSession.commit();;
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return (result > 0 && insertResult>0 && updateSectorResult>0);
    }

    public List<ProductDTO> gettStockList(Map<String,String> params) {

        SqlSession sqlSession = getSqlSession();
        warehouseMapper = sqlSession.getMapper(WarehouseMapper.class);

        int status = Status.STOCK.ordinal()+1;
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductStatus(status);

        int userSeq = 0;
        if (params.get("id") != null){
            userSeq= warehouseMapper.getUserSeq(params.get("id"));
        }
        productDTO.setUserSeq(userSeq);
        productDTO.setProductName(params.get("productName"));

        List<ProductDTO> stockList = warehouseMapper.findByStatusAndStock(productDTO);
        sqlSession.close();

        return stockList;

    }

    public List<ProductDTO> getNotificationProductList() {
        SqlSession sqlSession = getSqlSession();
        warehouseMapper = sqlSession.getMapper(WarehouseMapper.class);

        //오늘 날짜
        Timestamp today = Timestamp.valueOf(LocalDateTime.now());
        ProductDTO productDTO = new ProductDTO();
        productDTO.setExpirationDate(today);
        List<ProductDTO> notificationProductList = warehouseMapper.getNotificationProductList(productDTO);

        sqlSession.close();
        return notificationProductList;
    }

    public boolean addNotificationProduct(List<NotificationDTO> notificationList) {

        SqlSession sqlSession = getSqlSession();
        warehouseMapper = sqlSession.getMapper(WarehouseMapper.class);

        int result  = warehouseMapper.insertNotificationProduct(notificationList);
        if(result > 0){
            sqlSession.commit();;
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return (result > 0);

    }

    public List<ProductLogDTO> getProductLogList(Map<String, String> param) {

        SqlSession sqlSession = getSqlSession();
        warehouseMapper = sqlSession.getMapper(WarehouseMapper.class);

        List<ProductLogDTO> logList = warehouseMapper.getProductLogList(param);
        return logList;
    }

    public boolean addRequestReleaseList(List<RequestReleaseDTO> productDTOS) {
        SqlSession sqlSession = getSqlSession();
        warehouseMapper = sqlSession.getMapper(WarehouseMapper.class);
        int result = warehouseMapper.updateProductAmount(productDTOS);
        int insertResult = warehouseMapper.insertReleaseProductDate(productDTOS);
        int updateSectorResult = warehouseMapper.updateMinusSectorData(productDTOS);
        int updateOrdersResult = warehouseMapper.updateOrderStatus(productDTOS);
        if(result > 0 && insertResult>0 && updateSectorResult>0 && updateOrdersResult>0){
            sqlSession.commit();;
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return (result > 0 && insertResult>0 && updateSectorResult>0);
    }
}
