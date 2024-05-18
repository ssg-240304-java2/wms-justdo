package com.justdo.fruitfruit.controller;

import com.justdo.fruitfruit.model.dto.ProductDTO;
import com.justdo.fruitfruit.model.service.CommonService;
import com.justdo.fruitfruit.model.service.WarehouseService;
import com.justdo.fruitfruit.view.WarehouseResultMessage;

import java.util.List;

public class WarehouseController {

    private WarehouseService wareHouseService = new WarehouseService();
    private CommonService commonService = new CommonService();
    private WarehouseResultMessage resultMessage = new WarehouseResultMessage();

    /**
     * 상품상태가 입고요청인 상품목록 출력
     * */
    public void getRequestStockList() {
        List<ProductDTO> requestStockList = wareHouseService.getRequestStockList();
        resultMessage.printRequestStockList(requestStockList);
    }
}
