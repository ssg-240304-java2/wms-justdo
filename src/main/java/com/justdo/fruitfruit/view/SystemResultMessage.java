package com.justdo.fruitfruit.view;

import com.justdo.fruitfruit.model.dto.CompanyDTO;
import com.justdo.fruitfruit.model.dto.UserDTO;

import java.util.List;

public class SystemResultMessage {

    /***
     * userDTO 리스트를 받아와서 출력하는 함수
     * @param userList 회원 목록
     */
    public void printUserList(List<UserDTO> userList) {

        for (UserDTO user : userList) {
            System.out.println(user);
        }
    }

    /***
     * 에러 메시지를 출력하는 함수
     * @param errorCode
     */
    public void printErrorMessage(String errorCode) {
        String errorMessage = "";

        switch (errorCode) {
            case "selectUserList" :
                errorMessage = "회원 정보 조회를 실패하였습니다.";
                break;
            case "updateUser" :
                errorMessage = "회원 정보 수정을 실패하였습니다.";
                break;
            case "deleteUser" :
                errorMessage = "회원 정보 삭제를 실패하였습니다.";
                break;
            case "selectCompanyList" :
                errorMessage = "회사 정보 조회를 실패하였습니다.";
                break;
        }

        System.out.println(errorMessage);
    }

    /***
     * 성공 메시지를 출력하는 함수
     * @param successCode
     */
    public void printSuccessMessage(String successCode) {
        String successMessage = "";

        switch (successCode) {
            case "updateUser" :
                successMessage = "회원 정보 수정을 성공하였습니다.";
                break;
            case "deleteUser" :
                successMessage = "회원 정보 삭제를 성공하였습니다.";
                break;
        }

        System.out.println(successMessage);
    }

    /***
     * ComapanyDTO 리스트를 받아와서 출력하는 함수
     * @param companyList 회사 목록
     */
    public void printCompanyList(List<CompanyDTO> companyList) {
        for (CompanyDTO company : companyList) {
            System.out.println(company);
        }
    }
}
