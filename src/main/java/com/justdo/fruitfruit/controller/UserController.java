package com.justdo.fruitfruit.controller;

import com.justdo.fruitfruit.model.dto.UserDTO;
import com.justdo.fruitfruit.model.service.CommonService;
import com.justdo.fruitfruit.model.service.UserService;
import com.justdo.fruitfruit.view.ResultMessage;
import com.justdo.fruitfruit.view.UserMenu;

import java.util.List;
import java.util.Map;

public class UserController {

    private UserService userService = new UserService();
    private CommonService commonService = new CommonService();
    private ResultMessage resultMessage = new ResultMessage();
    private UserMenu userMenu = new UserMenu();
    public void selectAllUser() {
        List<UserDTO> userList = userService.selectAllUser();
        resultMessage.printUserList(userList);
    }
//    /**
//     * 사용자들의 로그인처리하는 함수
//     * @param id 입력한 아이디
//     * @param password 입력한 패스워드
//     * @return 로그인한 계정아이디를 반환
//     *         계정이없을경우 null값 반환
//     * */
    /***
     * 구매자 회원가입을 처리하는 함수
     * @param param 입력받은 회원정보
     * @return 입력받은 회원정보를 userDTO로 반환
     */
    public void insertUser(Map<String, String> param) {

        UserDTO userDTO = new UserDTO();
        userDTO.setId(param.get("id"));
        userDTO.setPassword(param.get("password"));
        userDTO.setName(param.get("name"));
        userDTO.setAddress(param.get("address"));
        userDTO.setPhoneNumber(param.get("phone"));
        userDTO.setAuth(Integer.parseInt(param.get("auth")));

        int result = userService.insertUser(userDTO);

        if(result > 0) {
            resultMessage.insertResult("insertSuccess");
        } else {
            resultMessage.insertResult("insertError");
        }
//        resultMessage.displayResult("회원등록", result);
    }

    public void loginUser(Map<String, String> param) {

        UserDTO userDTO = new UserDTO();
        userDTO.setId(param.get("id"));
        userDTO.setPassword(param.get("password"));

        UserDTO loginResult = commonService.login(userDTO);
        if(loginResult == null) {
            resultMessage.loginResult("loginError");
        } else {
            resultMessage.loginResult("loginSuccess");
            userMenu.consumerMenuView();
        }

    }
}
