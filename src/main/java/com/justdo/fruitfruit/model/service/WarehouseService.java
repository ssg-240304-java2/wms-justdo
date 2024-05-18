package com.justdo.fruitfruit.model.service;

import com.justdo.fruitfruit.common.constant.Status;
import com.justdo.fruitfruit.model.dao.WarehouseMapper;
import com.justdo.fruitfruit.model.dto.ProductDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

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
}
