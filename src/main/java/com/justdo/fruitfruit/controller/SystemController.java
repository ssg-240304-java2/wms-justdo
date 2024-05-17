package com.justdo.fruitfruit.controller;

import com.justdo.fruitfruit.model.dto.UserDTO;
import com.justdo.fruitfruit.model.service.SystemService;
import com.justdo.fruitfruit.view.ResultMessage;

import java.util.List;
import java.util.Map;

public class SystemController {

    private final ResultMessage resultMessage;
    private final SystemService systemService;

    public SystemController() {
        resultMessage = new ResultMessage();
        systemService = new SystemService();
    }

    /***
     * 회원 관리에서 모든 회원의 정보를 조회하는 함수
     */
    public void selectAllUser() {
        List<UserDTO> userList = systemService.selectAllUser();

        if (userList != null) {
            resultMessage.printUserList(userList);
        } else {
            resultMessage.printErrorMessage("selectList");
        }
    }

    /***
     * 회원 관리에서 선택한 회원의 정보를 수정하는 함수
     * @param user 선택한 회원의 변경할 정보
     */
    public void updateUser(Map<String, Object> user) {
        int result = systemService.updateUser(user);

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
    public void deleteUser(int userSeq) {
        int result = systemService.deleteUser(userSeq);

        if (result > 0) {
            resultMessage.printSuccessMessage("deleteUser");
        } else {
            resultMessage.printErrorMessage("deleteUser");
        }
    }
}
