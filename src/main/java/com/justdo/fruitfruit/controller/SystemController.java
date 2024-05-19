package com.justdo.fruitfruit.controller;

import com.justdo.fruitfruit.model.dto.CompanyDTO;
import com.justdo.fruitfruit.model.dto.UserDTO;
import com.justdo.fruitfruit.model.service.SystemService;
import com.justdo.fruitfruit.view.SystemResultMessage;

import java.util.List;
import java.util.Map;

public class SystemController {

    private SystemService systemService = new SystemService();

    private SystemResultMessage resultMessage = new SystemResultMessage();

    /* 회원 관리 메뉴 기능 */

    /***
     * 회원 관리에서 모든 회원의 정보를 조회하는 함수
     */
    public void getUserList() {
        List<UserDTO> userList = systemService.getUserList();

        if (userList != null) {
            resultMessage.printUserList(userList);
        } else {
            resultMessage.printErrorMessage("getUserList");
        }
    }

    /***
     * 회원 관리에서 선택한 회원의 정보를 수정하는 함수
     * @param userInfo 선택한 회원의 변경할 정보
     */
    public void updateUserInfo(Map<String, String> userInfo) {
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

        int result = systemService.updateUserInfo(user);

        if (result > 0) {
            resultMessage.printSuccessMessage("updateUserInfo");
        } else {
            resultMessage.printErrorMessage("updateUserInfo");
        }
    }

    /***
     * 회원 관리에서 선택한 회원의 정보를 삭제하는 함수
     * @param userSeq 선택한 회원의 sequence 번호
     */
    public void deleteUserInfo(String userSeq) {
        int result = systemService.deleteUserInfo(userSeq);

        if (result > 0) {
            resultMessage.printSuccessMessage("deleteUserInfo");
        } else {
            resultMessage.printErrorMessage("deleteUserInfo");
        }
    }

    /* 판매자 관리 메뉴 기능 */

    /***
     * 판매자 관리 메뉴에서 판매자 목록 조회
     */
    public void getSellerList() {
        List<CompanyDTO> sellerList = systemService.getSellerList();

        if (sellerList != null) {
            resultMessage.printCompanyList(sellerList);
        } else {
            resultMessage.printErrorMessage("getCompanyList");
        }
    }

    /***
     * 판매자 관리 메뉴에서 판매자 정보 수정
     * @param sellerInfo 판매자 정보
     */
    public void updateSellerInfo(Map<String, String> sellerInfo) {
        CompanyDTO company = new CompanyDTO();

        int userSeq = Integer.parseInt(sellerInfo.get("userSeq"));
        String companyName = sellerInfo.get("companyName");
        String companyPhone = sellerInfo.get("companyPhone");
        String companyAddress = sellerInfo.get("companyAddress");
        String companyNum = sellerInfo.get("companyNum");

        company.setUserSeq(userSeq);
        company.setCompanyName(companyName);
        company.setCompanyPhone(companyPhone);
        company.setCompanyAddress(companyAddress);
        company.setCompanyNum(companyNum);

        int result = systemService.updateSellerInfo(company);

        if (result > 0) {
            resultMessage.printSuccessMessage("updateSellerInfo");
        } else {
            resultMessage.printErrorMessage("updateSellerInfo");
        }
    }

    /***
     * 판매자 관리 메뉴에서 판매자 정보 삭제
     * @param sellerSeq
     */
    public void deleteSellerInfo(String sellerSeq) {
        int result = systemService.deleteSellerInfo(sellerSeq);

        if (result > 0) {
            resultMessage.printSuccessMessage("deleteSellerInfo");
        } else {
            resultMessage.printErrorMessage("deleteSellerInfo");
        }
    }

    /***
     * 판매자 관리 메뉴에서 판매자 권한 변경 요청자 목록 조회
     */
    public void getSellerRequestList() {
        List<CompanyDTO> sellerRequestList = systemService.getSellerRequestList();

        if (sellerRequestList != null) {
            resultMessage.printCompanyList(sellerRequestList);
        } else {
            resultMessage.printErrorMessage("getSellerRequestList");
        }
    }

    /***
     * 판매자 관리 메뉴에서 판매자 권한 업데이트 승인하는 함수
     * @param userAuthInfo 판매자 정보와 업데이트할 권한 정보
     */
    public void updateSellerAuth(Map<String, String> userAuthInfo) {
        UserDTO authInfo = new UserDTO();

        int userSeq = Integer.parseInt(userAuthInfo.get("userSeq"));
        int auth = Integer.parseInt(userAuthInfo.get("auth"));

        authInfo.setUserSeq(userSeq);
        authInfo.setAuth(auth);

        int result = systemService.updateSellerAuth(authInfo);

        if (result > 0) {
            resultMessage.printSuccessMessage("updateSellerAuth");
        } else {
            resultMessage.printErrorMessage("updateSellerAuth");
        }
    }
}