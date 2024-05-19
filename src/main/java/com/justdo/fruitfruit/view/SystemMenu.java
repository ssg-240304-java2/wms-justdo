package com.justdo.fruitfruit.view;

import com.justdo.fruitfruit.controller.InputReader;
import com.justdo.fruitfruit.controller.InputReaderFactory;
import com.justdo.fruitfruit.controller.SystemController;

import java.util.HashMap;
import java.util.Map;

public class SystemMenu {
    private InputReader inputReader = InputReaderFactory.getInputReader();
    private SystemController systemController = new SystemController();

    /***
     * 시스템 관리자 전용 메뉴 뷰
     */
    public void systemMainMenu() {
        do{
            System.out.println("""
                    ==========================
                    시 스 템 관 리 자 메 뉴
                    ==========================
                    1. 회원 관리
                    2. 판매자 관리
                    3. 상품 관리
                    4. 주문 관리
                    5. 배송 관리
                    9. 로그아웃
                    ==========================""");

            int menu = inputReader.selectMenuNum();
            switch (menu){
                case 1:
                    userManageSubMenu();
                    break;
//                case 2:
//                    sellerManageSubMenu();
//                    break;
//                case 3:
//                    productManageSubMenu();
//                    break;
//                case 4:
//                    orderManageSubMenu();
//                    break;
//                case 5:
//                    deliveryManageSubMenu();
//                    break;
                case 9:
                    System.out.println("로그아웃 하고, 메인 메뉴로 이동합니다.");
                    return;
                default:
                    System.out.println("메뉴를 확인하고 다시 입력해주세요.");
            }
        } while (true);
    }

    /***
     * 회원 관리 서브 메뉴 뷰
     */
    private void userManageSubMenu() {
        do {
            System.out.println("""
                ==========================
                회원 관리 메뉴
                ==========================
                1. 회원 정보 조회
                2. 회원 정보 수정
                3. 회원 정보 삭제
                9. 이전으로
                ==========================""");

            int menu = inputReader.selectMenuNum();
            switch (menu){
                case 1:
                    systemController.getUserList();
                    break;
                case 2:
                    System.out.print("검색할 회원의 번호를 입력해 주세요. :");
                    String userSeq = inputReader.inputString();

                    systemController.updateUserInfo(inputUserInfo(userSeq));
                    break;
                case 3:
                    System.out.print("검색할 회원의 번호를 입력해 주세요. :");
                    userSeq = inputReader.inputString();

                    systemController.deleteUserInfo(userSeq);
                    break;
                case 9:
                    System.out.println("이전화면으로 이동합니다.");
                    return;
                default:
                    System.out.println("메뉴를 확인하고 다시 입력해주세요.");
            }
        } while (true);
    }

    /***
     * 수정할 회원 번호와 회원 정보를 받아서 리턴하는 함수
     * @param userSeq 회원번호
     * @return 회원 번호, 회원 정보
     */
    private Map<String, String> inputUserInfo(String userSeq) {

        System.out.println("*** 회원 정보를 변경해 주세요. ***");
        System.out.print("> 변경할 이름 : ");
        String name = inputReader.inputString();
        System.out.print("> 변경할 전화번호 ('-' 제외 11자리) : ");
        String phoneNumber = inputReader.inputString();
        System.out.print("> 변경할 주소 : ");
        String address = inputReader.inputString();
        System.out.print("> 변경할 권한 (1: 시스템 관리자, 2: 창고 관리자, 3: 구매자, 4: 판매자) : ");
        String auth = inputReader.inputString();

        Map<String, String> user = new HashMap<>();
        user.put("userSeq", userSeq);
        user.put("name", name);
        user.put("phoneNumber", phoneNumber);
        user.put("address", address);
        user.put("auth", auth);

        return user;
    }
}