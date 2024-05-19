package com.justdo.fruitfruit.view;

import com.justdo.fruitfruit.model.dto.ProductDTO;

import java.util.List;

public class UserResultMessage {
    //success
    //error

    /***
     * 상품목록을 출력하는 메서드
     * @param productList 상품목록
     */
    public void printAllProductByUser (List<ProductDTO> productList) {
        for (ProductDTO product : productList) {
            System.out.println("조회 -> [" +
                    "물품 번호 = " + product.getProductSeq() +
                    ", 상품 이름 = '" + product.getProductName() + '\'' +
                    ", 수량 = " + product.getProductAmount() +
                    ", 무게 = " + product.getProductWeight() +
                    ", 가격 = " + product.getProductPrice() +
                    ", 카테고리 = '" + product.getCategoryName() + '\'' +
                    ", 등급 = '" + product.getGradeName() +
                    ']');
        }
    }




    public void insertResult(String msg){

        String status = "";
        switch(msg){
            case "insertSuccess" :
                status = "회원등록을 성공하였습니다.";
                break;
            case "insertError" :
                status = "회원등록을 실패하였습니다.";
                break;
        }
        System.out.println(status);
    }

    public void loginResult(String msg){

        String status = "";
        switch(msg){
            case "loginSuccess" :
                status = "로그인을 성공하였습니다.";
                break;
            case "loginError" :
                status = "로그인을 실패하였습니다.";
                break;
        }
        System.out.println(status);
    }

    public void printAllProductResult(String msg){

        String status = "";
        switch(msg){
            case "printSuccess" :
                status = "전체조회에 성공하였습니다.";
                break;
            case "printError" :
                status = "전체조회에 실패하였습니다.";
                break;
        }
        System.out.println(status);
    }

    public void printAllByCategoryResult(String msg){

        String status = "";
        switch(msg){
            case "printSuccess" :
                status = "카테고리별 물품 조회에 성공하였습니다.";
                break;
            case "printError" :
                status = "카테고리별 물품 실패하였습니다.";
                break;
        }
        System.out.println(status);
    }




}
