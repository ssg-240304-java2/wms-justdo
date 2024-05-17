package com.justdo.fruitfruit.view;

import com.justdo.fruitfruit.common.constant.Auth;
import com.justdo.fruitfruit.controller.InputReader;
import com.justdo.fruitfruit.controller.InputReaderFactory;
import com.justdo.fruitfruit.controller.ProductController;

import java.util.HashMap;
import java.util.Map;

public class UserMenu {

    private InputReader inputReader = InputReaderFactory.getInputReader();
    private ProductController productController = new ProductController();

    public void consumerMenuView() {
        while (true) {
            String menu = ("""
                    ================================
                    구 매 자 메 뉴
                    ================================
                    1. 물품 조회
                    2. 주문 내역 조회
                    3. 판매자 전환
                    9. 로그아웃
                    ================================""");
            System.out.println(menu);
            int choice = inputReader.selectMenuNum();

            switch (choice) {
                case 1:
                    searchProductMenu();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 9:
                    System.out.println("로그아웃이 완료되었습니다.");
                    return;
                default:
                    System.out.println("잘못된 메뉴를 선택하셨습니다. 다시 입력해주세요.");
            }
        }
    }

    public void searchProductMenu() {
        while(true) {
            String menu = ("""
                ================================
                물 품 조 회 메 뉴
                ================================
                1. 물품 전체 조회
                2. 물품 카테고리 조회
                9. 뒤로가기
                ================================""");
            System.out.println(menu);
            int choice = inputReader.selectMenuNum();
            switch (choice) {
                case 1:
                    productController.selectAllProduct();
                    break;
                case 2:
                    productController.selectByCategory();
                    break;
                case 9:
                    System.out.println("이전 메뉴로 돌아갑니다.");
                    return;
                default:
                    System.out.println("잘못된 메뉴를 선택하셨습니다. 다시 입력해주세요.");
            }
        }


    }

    /***
     * 구매자 회원가입 정보를 리턴하는 함수
     * @return 입력받은 회원정보를 반환
     */
    public Map<String, String> inputUser() {
        System.out.println("""
                ================================
                회 원 등록
                ================================""");
        System.out.print("아이디 : ");
        String id = inputReader.inputString();
        System.out.print("비밀번호 : ");
        String password = inputReader.inputString();
        System.out.print("이름 : ");
        String name = inputReader.inputString();
        System.out.print("핸드폰번호(하이픈(-)제외): ");
        String phone = inputReader.inputString();
        System.out.print("주소 : ");
        String address = inputReader.inputString();
        int auth = Auth.CONSUMER.ordinal() + 1;
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("password", password);
        map.put("name", name);
        map.put("address", address);
        map.put("phone", phone);
        map.put("auth", String.valueOf(auth));
        return map;
    }

    // 로그인할 아이디
    public Map<String, String> inputLogin() {
        System.out.print("아이디 : ");
        String id = inputReader.inputString();
        System.out.print("패스워드 : ");
        String password = inputReader.inputString();
        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("password", password);
        return map;
    }

    public Map<String, String> inputNum() {
        System.out.print("장바구니 담기(상품번호 입력) : ");
        String num = inputReader.inputString();
        Map<String, String> map = new HashMap<>();
        map.put("num", num);
        return map;
    }



}
