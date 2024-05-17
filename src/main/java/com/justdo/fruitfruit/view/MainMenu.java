package com.justdo.fruitfruit.view;

import com.justdo.fruitfruit.controller.InputReader;
import com.justdo.fruitfruit.controller.SystemController;

import java.util.HashMap;
import java.util.Map;

public class MainMenu {
    public void mainMenuView(){
        systemMenuView();
    }

    /***
     * 시스템 관리자의 메뉴를 보여주는 함수
     */
    public void systemMenuView() {
        InputReader ir = new InputReader();

        boolean isOn = true;

        while (isOn) {
            System.out.println("""
                =====================
                🗽 시스템 관리자 메뉴 🗽
                =====================
                1. 회원 관리 메뉴
                2. 판매자 관리 메뉴
                3. 상품 관리 메뉴
                4. 주문 관리 메뉴
                5. 배송 관리 메뉴
                9. 종료
                =====================
                """);
            int select = ir.selectMenuNum();

            switch (select) {
                case 1:
                    userManageMenuView();
                    break;
                case 2:
//                    sellerManageMenuView();
//                    break;
//                case 3:
//                    productManageMenuView();
//                    break;
//                case 4:
//                    orderManageMenuView();
//                    break;
//                case 5:
//                    deliveryManageMenuView();
//                    break;
                case 9:
                    isOn = false;
                default:
                    System.out.println("정확한 메뉴 번호를 입력해 주세요.");
                    break;
            }
        }

        ir.close();
    }

//    private void sellerManageMenuView() {
//    }

    /***
     * 회원 관리 메뉴를 보여주는 함수
     */
    private void userManageMenuView() {
        InputReader ir = new InputReader();
        SystemController systemController = new SystemController();

        boolean isOn = true;

        while (isOn) {
            System.out.println("""
                =====================
                🗽 회원 관리 메뉴 🗽
                =====================
                1. 회원 정보 조회
                2. 회원 정보 수정
                3. 회원 정보 삭제
                9. 이전 메뉴 
                =====================
                """);
            int select = ir.selectMenuNum();

            switch (select) {
                case 1:
                    systemController.selectAllUser();
                    break;
                case 2:
                    systemController.updateUser(inputUserUpdated());
                    break;
                case 3:
                    systemController.deleteUser(inputUserSeq());
                    break;
                case 9:
                    isOn = false;
                default:
                    System.out.println("정확한 메뉴 번호를 입력해 주세요.");
                    break;
            }
        }

        ir.close();
    }

    private int inputUserSeq() {
        InputReader ir = new InputReader();

        System.out.print("> 삭제할 회원의 번호를 입력해 주세요. : ");
        Integer userSeq = ir.inputIntValue();

        return userSeq;
    }

    /***
     * 회원 관리에서 수정할 회원의 정보를 작성하는 함수
     * @return
     */
    private Map<String, Object> inputUserUpdated() {
        InputReader ir = new InputReader();

        System.out.print("> 변경할 회원의 코드를 입력해 주세요. : ");
        Integer userSeq = ir.inputIntValue();
        System.out.println("*** 변경할 회원의 정보를 작성해 주세요. ***");
        System.out.print("> 변경할 이름 : ");
        String name = ir.inputString();
        System.out.print("> 변경할 전화번호 ('-' 제외 11자리) : ");
        String phoneNumber = ir.inputString();
        System.out.print("> 변경할 주소 : ");
        String address = ir.inputString();
        System.out.print("> 변경할 권한 (1: 시스템 관리자, 2: 창고 관리자, 3: 구매자, 4: 판매자) : ");
        Integer auth = ir.inputIntValue();

        Map<String, Object> user = new HashMap<>();
        user.put("userSeq", userSeq);
        user.put("name", name);
        user.put("phoneNumber", phoneNumber);
        user.put("address", address);
        user.put("auth", auth);

        ir.close();

        return user;
    }
}