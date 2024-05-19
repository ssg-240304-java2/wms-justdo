package com.justdo.fruitfruit.view;

import com.justdo.fruitfruit.common.constant.Status;
import com.justdo.fruitfruit.model.dto.GradeDTO;
import com.justdo.fruitfruit.model.dto.ProductDTO;
import com.justdo.fruitfruit.model.dto.ProductLogDTO;
import com.justdo.fruitfruit.model.dto.SectorDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
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
            case "addNotificationInfo":
                errorMsg = "알림 등록에 실패하였습니다.";
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
            case "addNotificationInfo":
                successMsg = "알림이 성공적으로 등록되었습니다.";
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

    public void printStockList(List<ProductDTO> stockList) {
        if(stockList == null || stockList.isEmpty()){
            System.out.println("> 😅😅😅 조회된 입고요청이 없습니다. 😅😅😅");
        }else {
            //(상품카테고리/상품명/ 보관장소/갯수/유통기한/판매자)
            System.out.println("-----------------------------------------------");
            System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\n", "상품번호","카테고리명", "상품명","창고 구역", "수량", "유통기한");
            System.out.println("-----------------------------------------------");
            int index= 1;
            for(ProductDTO productDTO : stockList){
                System.out.printf("%d\t%s\t%s\t%s\t%d\t%s\n",
                        index,
                        productDTO.getCategoryName(),
                        productDTO.getProductName(),
                        productDTO.getSectorName(),
                        productDTO.getProductAmount(),
                        productDTO.getExpirationDate().toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                );
                index++;
            }
            System.out.println("-----------------------------------------------");
        }
    }

    public void printNotificationProductList(List<ProductDTO> notificationProductList) {

        if(notificationProductList == null || notificationProductList.isEmpty()){
            System.out.println("> 😅😅😅 조회된 알림을 보낼 상품이 없습니다. 😅😅😅");
        }else {
            //(상품카테고리/상품명/ 보관장소/갯수/유통기한/판매자)
            System.out.println("-----------------------------------------------");
            System.out.printf("%s\t%s\t%s\t%s\t%s\n","상품번호","알림구분","카테고리명", "상품명","수량", "유통기한");

            System.out.println("-----------------------------------------------");
            int index= 1;
            for(ProductDTO productDTO : notificationProductList){
                System.out.printf("%d\t%s\t%s\t%s\t%d\t%s\n",
                        index,
                        productDTO.getNotificationType(),
                        productDTO.getCategoryName(),
                        productDTO.getProductName(),
                        productDTO.getProductAmount(),
                        productDTO.getExpirationDate().toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                );
                index++;
            }
            System.out.println("-----------------------------------------------");
        }

    }

    public void printProducLogList(List<ProductLogDTO> logList) {
        if(logList == null || logList.isEmpty()){
            System.out.println("> 😅😅😅 조회된 로그가 없습니다. 😅😅😅");
        }else {
            //(상품카테고리/상품명/ 보관장소/갯수/유통기한/판매자)
            System.out.println("-----------------------------------------------");
            System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\n","로그번호","작업구분","카테고리명", "상품명","재고위치", "수량");
            System.out.println("-----------------------------------------------");
            int index= 1;
            for(ProductLogDTO logDTO : logList){
                String statusName = getStatusName(logDTO.getStatus());
                System.out.printf("%d\t%s\t%s\t%s\t%s\t%d\n",
                        index,
                        statusName,
                        logDTO.getCategoryName(),
                        logDTO.getProductName(),
                        logDTO.getSectorName(),
                        logDTO.getLogAmount()
                );
                index++;
            }
            System.out.println("-----------------------------------------------");
        }
    }

    private String getStatusName(int status) {
        switch (status){
            case 1:
                return Status.REQUEST_STOCK.getStatus();
            case 2:
                return Status.STOCK.getStatus();
            case 3:
                return Status.REQUEST_RELEASE.getStatus();
            case 4:
                return Status.RELEASE.getStatus();
            default:
                System.out.println(status);
                return "일치하는 카테고리없음";
        }
    }
}
