package com.justdo.fruitfruit.model.service;

import com.justdo.fruitfruit.controller.InputReader;
import com.justdo.fruitfruit.controller.InputReaderFactory;

public class CommonService {

    private InputReader inputReader = InputReaderFactory.getInputReader();

    /**
     * 사용자들의 로그인처리하는 함수
     * @param id 입력한 아이디
     * @param password 입력한 패스워드
     * @return 로그인한 계정아이디를 반환
     *         계정이없을경우 null값 반환
     * */
    public String Login(String id,String password){
        return null;
    }
}
