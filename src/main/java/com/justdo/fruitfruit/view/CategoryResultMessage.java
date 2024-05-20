package com.justdo.fruitfruit.view;

import com.justdo.fruitfruit.model.dto.CategoryDTO;

import java.util.List;

public class CategoryResultMessage {
    /***
     * 카테고리 목록을 출력하는 메서드
     * @param categoryList 카테고리목록
     */

    public void printAllCategory (List<CategoryDTO> categoryList) {
        for (CategoryDTO category : categoryList) {
            System.out.println(category);
        }
    }

    public void printAllCategoryResult(String msg){

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
