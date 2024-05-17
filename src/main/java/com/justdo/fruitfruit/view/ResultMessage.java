package com.justdo.fruitfruit.view;

import com.justdo.fruitfruit.model.dto.UserDTO;

import java.util.List;

public class ResultMessage {
    //success
    //error

    public void printUserList(List<UserDTO> userList) {

        for (UserDTO user : userList) {
            System.out.println(user);
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

}
