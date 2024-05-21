package com.justdo.fruitfruit.view;

import com.justdo.fruitfruit.model.dto.ProductDTO;

import java.util.List;

public class ProductResultMessage {
    //success
    //error

    public void productSuccessMessage(String successCode) {
        String successMessage = "";
        switch (successCode) {
            case "register":
                successMessage = "신규 상품 등록이 완료되었습니다.";
                break;
            case "modify":
                successMessage = "상품 수정이 완료되었습니다.";
                break;
            case "delete":
                successMessage = "상품 삭제가 완료되었습니다.";
                break;
        }
        System.out.println(successMessage);
    }

    public void productFailureMessage(String failureCode) {
        String failureMessage = "";
        switch (failureCode) {
            case "viewAll":
                failureMessage = "상품 조회를 실패하였습니다.";
                break;
            case "register":
                failureMessage = "신규 상품 등록을 실패하였습니다.";
                break;
            case "modify":
                failureMessage = "상품 수정을 실패하였습니다.";
                break;
            case "delete":
                failureMessage = "상품 삭제를 실패하였습니다.";
                break;
            case "viewNone":
                failureMessage = "조회할 상품정보가 없습니다.";
                break;
        }
        System.out.println(failureMessage);
    }

    public void printAllProduct(List<ProductDTO> productList) {
        for (ProductDTO product : productList) {
            System.out.println(product);
        }
    }
}
