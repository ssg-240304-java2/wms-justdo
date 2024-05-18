package com.justdo.fruitfruit.view;

import com.justdo.fruitfruit.model.dto.GradeDTO;
import com.justdo.fruitfruit.model.dto.ProductDTO;
import com.justdo.fruitfruit.model.dto.SectorDTO;

import java.util.List;

public class WarehouseResultMessage {

    public void errorMessage(String errorCode) {
        String errorMsg = "";
        switch (errorCode) {
            case "addRequestStock":
                errorMsg="입고처리할 상품정보가 없습니다.";
                break;
            case "addRequestStock2":
                errorMsg = "입고처리에 실패하였습니다";
                break;

        }
        System.out.println(errorMsg);
    }

    public void susccessMessage(String successCode){
        String successMsg = "";
        switch (successCode) {
            case "addRequestStock":
                successMsg = "입고처리가 성공적으로 완료되었습니다.";
                break;
        }
        System.out.println(successMsg);
    }

    public void printRequestStockList(List<ProductDTO> requestStockList) {
        if(requestStockList == null || requestStockList.isEmpty()){
            System.out.println("> 😅😅😅 조회된 입고요청이 없습니다. 😅😅😅");
        }else {
            System.out.println("-----------------------------------------------");
            System.out.printf("%s\t%s\t%s\t%s\n", "상품번호","카테고리명", "상품명", "수량");
            System.out.println("-----------------------------------------------");
            int index= 1;
            for(ProductDTO productDTO : requestStockList){
                System.out.printf("%d\t%s\t%s\t%d\n",
                        index,
                        productDTO.getCategoryName(),
                        productDTO.getProductName(),
                        productDTO.getProductAmount());
                index++;
            }
            System.out.println("-----------------------------------------------");
        }
    }

    public void printRequestReleaseList(List<ProductDTO> requestReleaseList) {
        if(requestReleaseList == null || requestReleaseList.isEmpty()){
            System.out.println("> 😅😅😅 조회된 출고요청이 없습니다. 😅😅😅");
        }else {
            System.out.println("-----------------------------------------------");
            System.out.printf("%s\t%s\t%s\t%s\n", "상품번호","카테고리명", "상품명", "수량");
            System.out.println("-----------------------------------------------");
            int index = 1;
            for(ProductDTO productDTO : requestReleaseList){
                System.out.printf("%s\t%s\t%s\t%d\n",
                        index,
                        productDTO.getCategoryName(),
                        productDTO.getProductName(),
                        productDTO.getProductAmount());
                index++;
            }
            System.out.println("-----------------------------------------------");
        }
    }


    public void printGradeList(List<GradeDTO> gradeList) {
        if(gradeList == null || gradeList.isEmpty()){
            System.out.println("> 😅😅😅 조회된 등급정보가 없습니다. 😅😅😅");
        }else {
            System.out.println("-----------------------------------------------");
            System.out.printf("%s\t%s\t%s\n", "등급번호","카테고리명", "등급명");
            System.out.println("-----------------------------------------------");
            int index= 1;
            for(GradeDTO gradeDTO : gradeList){
                System.out.printf("%d\t%s\t%s\n",
                        index,
                        gradeDTO.getCategoryName(),
                        gradeDTO.getGradeName());
                index++;
            }
            System.out.println("-----------------------------------------------");
        }
    }

    public void printSectorList(List<SectorDTO> sectorList) {
        if(sectorList == null || sectorList.isEmpty()){
            System.out.println("> 😅😅😅 조회된 창고정보가 없습니다. 😅😅😅");
        }else {
            System.out.println("-----------------------------------------------");
            System.out.printf("%s\t%s\t%s\n", "구역번호","구역명", "남은 공간");
            System.out.println("-----------------------------------------------");
            int index= 1;
            for(SectorDTO sectorDTO : sectorList){
                System.out.printf("%d\t%s\t%s\n",
                        index,
                        sectorDTO.getSectorName(),
                        sectorDTO.getVolume());
                index++;
            }
            System.out.println("-----------------------------------------------");
        }
    }
}
