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
                case 2:
                    sellerManageSubMenu();
                    break;
                case 3:
                    productManageSubMenu();
                    break;
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
     * 상품 관리 서브 메뉴 뷰
     */
    private void productManageSubMenu() {
        do {
            System.out.println("""
                ==========================
                상품 관리 메뉴
                ==========================
                1. 상품 전체 조회
                2. 판매 등록된 상품 조회
                3. 상품 삭제
                9. 이전으로
                ==========================""");

            int menu = inputReader.selectMenuNum();
            switch (menu){
                case 1:
                    systemController.getProductAllList();
                    break;
                case 2:
                    systemController.getProductSaleList();
                    break;
                case 3:
                    System.out.print("삭제할 상품의 번호를 입력해 주세요. : ");
                    String productSeq = inputReader.inputString();

                    systemController.deleteProductInfo(productSeq);
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
     * 판매자 관리 서브 메뉴 뷰
     */
    private void sellerManageSubMenu() {
        do {
            System.out.println("""
                ==========================
                판매자 관리 메뉴
                ==========================
                1. 판매자 정보 조회
                2. 판매자 정보 수정
                3. 판매자 정보 삭제
                4. 판매자 권한 요청 확인
                5. 판매자 권한 수정
                9. 이전으로
                ==========================""");

            int menu = inputReader.selectMenuNum();
            switch (menu){
                case 1:
                    systemController.getSellerList();
                    break;
                case 2:
                    System.out.print("판매자 정보를 수정할 회원의 번호를 입력해 주세요. : ");
                    String sellerSeq = inputReader.inputString();

                    systemController.updateSellerInfo(inputSellerInfo(sellerSeq));
                    break;
                case 3:
                    System.out.print("판매자 정보를 삭제할 회원의 번호를 입력해 주세요. : ");
                    sellerSeq = inputReader.inputString();

                    systemController.deleteSellerInfo(sellerSeq);
                    break;
                case 4:
                    systemController.getSellerRequestList();
                    break;
                case 5:
                    System.out.print("판매자 권한을 부여할 회원의 번호를 입력해 주세요. : ");
                    sellerSeq = inputReader.inputString();

                    systemController.updateSellerAuth(inputSellerAuth(sellerSeq));
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
     * 판매자 권한을 수정할 값을 입력 받는 함수
     * @param sellerSeq 수정할 판매자의 회원 번호
     * @return 판매자 권한 정보
     */
    private Map<String, String> inputSellerAuth(String sellerSeq) {
        System.out.println("> 회원에게 판매자 권한을 부여하시겠습니까?");
        System.out.print("> Y / N : ");
        String select = inputReader.inputString();

        Map<String, String> auth = new HashMap<>();
        if ((select.equals("y") || select.equals("Y"))) {
            auth.put("userSeq", sellerSeq);
            auth.put("auth", "4");
        } else {
            auth.put("userSeq", sellerSeq);
            auth.put("auth", "3");
        }

        return auth;
    }

    /***
     * 판매자 정보를 수정할 값을 입력받는 함수
     * @param sellerSeq 수정할 판매자의 회원 번호
     * @return 판매자 정보
     */
    private Map<String, String> inputSellerInfo(String sellerSeq) {
        System.out.println("*** 판매자 정보를 변경해 주세요. ***");
        System.out.print("> 변경할 판매자 이름 : ");
        String companyName = inputReader.inputString();
        System.out.print("> 변경할 판매자 전화번호 ('-' 제외 11자리) : ");
        String companyPhone = inputReader.inputString();
        System.out.print("> 변경할 판매자 주소 : ");
        String companyAddress = inputReader.inputString();
        System.out.print("> 변경할 판매자 사업자 번호 : ");
        String companyNum = inputReader.inputString();

        Map<String, String> seller = new HashMap<>();
        seller.put("userSeq", sellerSeq);
        seller.put("companyName", companyName);
        seller.put("companyPhone", companyPhone);
        seller.put("companyAddress", companyAddress);
        seller.put("companyNum", companyNum);

        return seller;
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
                    System.out.print("회원 정보를 수정할 회원의 번호를 입력해 주세요. :");
                    String userSeq = inputReader.inputString();

                    systemController.updateUserInfo(inputUserInfo(userSeq));
                    break;
                case 3:
                    System.out.print("회원 정보를 삭제할 회원의 번호를 입력해 주세요. :");
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
        System.out.print("> 변경할 회원 이름 : ");
        String name = inputReader.inputString();
        System.out.print("> 변경할 회원 전화번호 ('-' 제외 11자리) : ");
        String phoneNumber = inputReader.inputString();
        System.out.print("> 변경할 회원 주소 : ");
        String address = inputReader.inputString();
        System.out.print("> 변경할 회원 권한 (1: 시스템 관리자, 2: 창고 관리자, 3: 구매자, 4: 판매자) : ");
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