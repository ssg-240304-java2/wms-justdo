package com.justdo.fruitfruit.view;

import com.justdo.fruitfruit.model.dto.ProductDTO;

import java.util.List;

public class WarehouseResultMessage {

    public void errorMessage(String errorCode) {
        String errorMsg = "";
        switch (errorCode) {

        }
    }

    public void susccessMessage(String successCode){
        String successMsg = "";
        switch (successCode) {

        }
    }

    public void printRequestStockList(List<ProductDTO> requestStockList) {
        if(requestStockList == null || requestStockList.isEmpty()){
            System.out.println("> 😅😅😅 조회된 입고요청이 없습니다. 😅😅😅");
        }else {
            System.out.println("-----------------------------------------------");
            System.out.printf("%s\t%s\t%s\n", "카테고리명", "상품명", "수량");
            System.out.println("-----------------------------------------------");
            for(ProductDTO productDTO : requestStockList){
                System.out.printf("%s\t%s\t%d\n",
                        productDTO.getCategoryName(),
                        productDTO.getProductName(),
                        productDTO.getProductAmount());
            }
            System.out.println("-----------------------------------------------");
        }
    }
}
