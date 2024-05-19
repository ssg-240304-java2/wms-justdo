package com.justdo.fruitfruit.controller;

import com.justdo.fruitfruit.model.dto.CompanyDTO;
import com.justdo.fruitfruit.model.dto.UserDTO;
import com.justdo.fruitfruit.model.service.CommonService;
import com.justdo.fruitfruit.model.service.UserService;
import com.justdo.fruitfruit.view.*;

import java.util.Map;

public class UserController {

    private final UserService userService = new UserService();
    private final CommonService commonService = new CommonService();
    private final UserResultMessage userResultMessage = new UserResultMessage();
    private final UserMenu userMenu = new UserMenu();
    private final WarehouseMenu warehouseMenu = new WarehouseMenu();
    private SellerMenu sellerMenu;

    private final SystemMenu systemMenu = new SystemMenu();
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
            userResultMessage.insertResult("insertSuccess");
        } else {
            userResultMessage.insertResult("insertError");
        }
    }

    /***
     * 로그인을 처리하는 함수
     * @param param 회원 아이디, 비밀번호
     */
    public void loginUser(Map<String, String> param) {

        UserDTO userDTO = new UserDTO();
        userDTO.setId(param.get("id"));
        userDTO.setPassword(param.get("password"));

        UserDTO loginResult = commonService.login(userDTO);
        if(loginResult == null) {
            userResultMessage.loginResult("loginError");
        } else {
            userResultMessage.loginResult("loginSuccess");
            switch (loginResult.getAuth()) {
                case 1:
                    systemMenu.systemMainMenu(); // 시스템관리자 메뉴로 이동
                    break;
                case 2:
                    warehouseMenu.warehouseMainMenu(); // 창고관리자 메뉴로 이동
                    break;
                case 3:
                    userMenu.consumerMenuView(loginResult); // 로그인한 회원정보를 담아서 구매자 메뉴로 이동
                    break;
                case 4:
                    sellerMenu = new SellerMenu(loginResult);
                    sellerMenu.SellerMenuView(); // 판매자 메뉴로 이동
                    break;
            }

        }
    }

    /***
     * 회원 아이디찾기 메서드
     * @param param 회원 이름, 핸드폰번호
     */
    public void findUserId(Map<String, String> param) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(param.get("name"));
        userDTO.setPhoneNumber(param.get("phone"));


        UserDTO findResult = userService.findUserId(userDTO);

        if (findResult != null) {
            System.out.println("아이디 : " + findResult.getId());
        } else {
            System.out.println("일치하는 사용자를 찾을 수 없습니다.");
        }
    }


    /***
     * 회원 비밀번호찾기 메서드
     * @param param 회원 아이디, 회원 이름, 핸드폰번호
     */
    public void findUserPassword(Map<String, String> param) {

        UserDTO userDTO = new UserDTO();
        userDTO.setId(param.get("id"));
        userDTO.setName(param.get("name"));
        userDTO.setPhoneNumber(param.get("phone"));

        UserDTO existUser = userService.existUserByInfo(userDTO);

        if(existUser != null) {
            Map<String, String> passwordMap = userMenu.inputNewPassword();
            String newPassword = passwordMap.get("password");
            userDTO.setPassword(newPassword);
            int result = userService.findUserPassword(userDTO);

            if(result > 0) {
                userResultMessage.findUserPassword("findSuccess");
            } else {
                userResultMessage.findUserPassword("findError");
            }
        } else {
            userResultMessage.findUserPassword("userNotFound");
        }
    }



}
