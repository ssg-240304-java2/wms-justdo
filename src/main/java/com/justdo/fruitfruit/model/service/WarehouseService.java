package com.justdo.fruitfruit.model.service;

import com.justdo.fruitfruit.common.constant.Status;
import com.justdo.fruitfruit.model.dao.WarehouseMapper;
import com.justdo.fruitfruit.model.dto.GradeDTO;
import com.justdo.fruitfruit.model.dto.ProductDTO;
import com.justdo.fruitfruit.model.dto.SectorDTO;
import org.apache.ibatis.session.SqlSession;

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

    public List<ProductDTO> getRequestReleaseList() {
        SqlSession sqlSession = getSqlSession();
        warehouseMapper = sqlSession.getMapper(WarehouseMapper.class);

        int status = Status.REQUEST_RELEASE.ordinal()+1;
        List<ProductDTO> requestReleaseList = warehouseMapper.findByStatus(status);
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
        if(result > 0 && insertResult>0){
            sqlSession.commit();;
        }else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return (result > 0 && insertResult>0);
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
}
