package com.justdo.fruitfruit.view;

public class CompanyResultMessage {
    public void companyInsertResult(String msg){

        String status = "";
        switch(msg){
            case "insertSuccess" :
                status = "판매자등록을 성공하였습니다.";
                break;
            case "insertError" :
                status = "판매자등록을 실패하였습니다.";
                break;
        }
        System.out.println(status);
    }
}
