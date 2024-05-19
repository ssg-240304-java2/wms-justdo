package com.justdo.fruitfruit.view;

import com.justdo.fruitfruit.common.constant.Auth;
import com.justdo.fruitfruit.controller.*;

import java.util.HashMap;
import java.util.Map;

public class UserMenu {

    private final InputReader inputReader = InputReaderFactory.getInputReader();
    private final ProductController productController = new ProductController();
    private final CategoryController categoryController = new CategoryController();
    private final CompanyController companyController = new CompanyController();


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
                    companyController.insertCompany(inputCompany());
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
                상 품 조 회 메 뉴
                ================================
                1. 상품 전체 조회
                2. 상품 카테고리 조회
                9. 뒤로가기
                ================================""");
            System.out.println(menu);
            int choice = inputReader.selectMenuNum();
            switch (choice) {
                case 1:
                    productController.selectAllProductByConsumer();
                    break;
                case 2:
                    categoryController.selectAllCategory();
                    productController.selectAllProductByCategory(inputCategoryNum());
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
                회 원 등 록
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

    /***
     * 로그인 정보를 리턴하는 함수
     * @return 입력받은 아이디 패스워드 반환
     */
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

    /***
     * 카테고리 번호를 리턴하는 함수
     * @return 입력받은 카테고리 번호 반환
     */
    public int inputCategoryNum() {
        System.out.print("카테고리 번호 입력 : ");
        return inputReader.inputIntValue();
    }

    /***
     * 판매자 전환 정보를 리턴하는 함수
     * @return 입력받은 판매자 정보 반환
     */
    public Map<String, String> inputCompany() {
        System.out.print("회사명을 입력하세요 : ");
        String companyName = inputReader.inputString();
        System.out.print("회사전화번호를 입력하세요 : ");
        String companyPhone = inputReader.inputString();
        System.out.print("사업자번호를 입력하세요 : ");
        String companyNum = inputReader.inputString();
        System.out.print("회사주소 입력하세요 : ");
        String companyAddress = inputReader.inputString();

        Map<String, String> map = new HashMap<>();
        map.put("companyName", companyName);
        map.put("companyPhone", companyPhone);
        map.put("companyNum", companyNum);
        map.put("companyAddress", companyAddress);
        return map;
    }

    /***
     * 상품 번호를 리턴하는 함수
     * @return 입력받은 상품 번호 반환
     */
    public String inputProductNum() {
        System.out.print("장바구니 담기(상품번호 입력) : ");
        return inputReader.inputString();
    }




}
