package com.justdo.fruitfruit.controller;

import com.justdo.fruitfruit.model.dto.GradeDTO;
import com.justdo.fruitfruit.model.dto.ProductDTO;
import com.justdo.fruitfruit.model.dto.SectorDTO;
import com.justdo.fruitfruit.model.service.WarehouseService;
import com.justdo.fruitfruit.view.WarehouseResultMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WarehouseController {

    private WarehouseService wareHouseService = new WarehouseService();
    private WarehouseResultMessage resultMessage = new WarehouseResultMessage();

    /**
     * 상품상태가 입고요청인 상품목록 출력
     * */
    public List<ProductDTO> getRequestStockList() {
        List<ProductDTO> requestStockList = wareHouseService.getRequestStockList();
        resultMessage.printRequestStockList(requestStockList);
        return requestStockList;
    }

    /**
     * 입고요청 상태의 상품 입고 처리
     * */
    public void addRequestStockList(List<ProductDTO> productDTOS) {
        if(productDTOS == null || productDTOS.isEmpty()){
            resultMessage.errorMessage("addRequestStock");
        }

        boolean result = wareHouseService.addRequestStockList(productDTOS);
        if(result){
            resultMessage.susccessMessage("addRequestStock");
        }else{
            resultMessage.errorMessage("addRequestStock2");
        }
    }

    /**
     * 상품상태가 출고요청인 상품목록 출력
     * */
    public void getRequestReleaseList() {
        List<ProductDTO> requestReleaseList = wareHouseService.getRequestReleaseList();
        resultMessage.printRequestStockList(requestReleaseList);
    }


    /**
     * 카테고리별 등급리스트를 출력
     * */
    public List<GradeDTO> getGradeList(int categorySeq) {

        List<GradeDTO> gradeList = wareHouseService.getGradeList(categorySeq);
        resultMessage.printGradeList(gradeList);
        return gradeList;
    }

    public List<SectorDTO> getSectorList(int productAmount) {
        List<SectorDTO> sectorList = wareHouseService.getSectorList(productAmount);
        resultMessage.printSectorList(sectorList);
        return sectorList;
    }
}
