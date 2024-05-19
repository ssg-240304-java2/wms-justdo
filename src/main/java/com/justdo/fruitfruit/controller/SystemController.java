package com.justdo.fruitfruit.controller;

import com.justdo.fruitfruit.model.dto.UserDTO;
import com.justdo.fruitfruit.model.service.SystemService;
import com.justdo.fruitfruit.view.SystemResultMessage;

import java.util.List;
import java.util.Map;

public class SystemController {

    private SystemService systemService = new SystemService();

    private SystemResultMessage resultMessage = new SystemResultMessage();

    /* 회원 관리 메뉴 */

    /***
     * 회원 관리에서 모든 회원의 정보를 조회하는 함수
     */
    public void getUserList() {
        List<UserDTO> userList = systemService.getUserList();

        if (userList != null) {
            resultMessage.printUserList(userList);
        } else {
            resultMessage.printErrorMessage("selectUserList");
        }
    }

    /***
     * 회원 관리에서 선택한 회원의 정보를 수정하는 함수
     * @param userInfo 선택한 회원의 변경할 정보
     */
    public void updateUserInfo(Map<String, String> userInfo) {
        System.out.println("dd");

        UserDTO user = new UserDTO();

        int userSeq = Integer.parseInt(userInfo.get("userSeq"));
        String name = userInfo.get("name");
        String phoneNumber = userInfo.get("phoneNumber");
        String address = userInfo.get("address");
        int auth = Integer.parseInt(userInfo.get("auth"));

        user.setUserSeq(userSeq);
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        user.setAddress(address);
        user.setAuth(auth);

        System.out.println("sdfdfff");

        int result = systemService.updateUserInfo(user);

        if (result > 0) {
            resultMessage.printSuccessMessage("updateUser");
        } else {
            resultMessage.printErrorMessage("updateUser");
        }
    }

    /***
     * 회원 관리에서 선택한 회원의 정보를 삭제하는 함수
     * @param userSeq 선택한 회원의 sequence 번호
     */
    public void deleteUserInfo(String userSeq) {
        int result = systemService.deleteUserInfo(userSeq);

        if (result > 0) {
            resultMessage.printSuccessMessage("deleteUser");
        } else {
            resultMessage.printErrorMessage("deleteUser");
        }
    }
}
