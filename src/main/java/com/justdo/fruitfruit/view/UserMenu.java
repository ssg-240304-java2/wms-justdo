package com.justdo.fruitfruit.view;

import com.justdo.fruitfruit.common.constant.Auth;
import com.justdo.fruitfruit.controller.*;
import com.justdo.fruitfruit.model.dto.UserDTO;

import java.util.HashMap;
import java.util.Map;

public class UserMenu {

    private final InputReader inputReader = InputReaderFactory.getInputReader();
    private final ProductController productController = new ProductController();
    private final CategoryController categoryController = new CategoryController();
    private final CompanyController companyController = new CompanyController();


    public void consumerMenuView(UserDTO loginResult) {
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
                    searchProductMenu(); // 물품 조회
                    break;
                case 2:
                    break;
                case 3:
                    companyController.insertCompany(inputCompany(loginResult)); // 판매자 전환
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
        boolean isValidPassword = false;
        String id, password, name, phone, address;

        do {
            System.out.println("""
                    ================================
                    회 원 등 록
                    ================================""");
            System.out.print("아이디 : ");
            id = inputReader.inputString();
            System.out.print("비밀번호 : ");
            password = inputReader.inputString();
            System.out.print("이름 : ");
            name = inputReader.inputString();
            System.out.print("핸드폰번호(하이픈(-)제외): ");
            phone = inputReader.inputString();
            System.out.print("주소 : ");
            address = inputReader.inputString();

            isValidPassword = isValidPassword(password);
            if (!isValidPassword) {
                System.out.println("비밀번호는 최소 8자리 / 1개 이상의 숫자, 영문 대소문자, 특수 기호를 포함해야 합니다.");
                System.out.println("다시 입력해주세요.\n");
            }
        } while (!isValidPassword);

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
     * @param password 입력받은 비밀번호 체크
     * @return boolean 결과값 모두 일치하면 true 반환
     * */
    public boolean isValidPassword(String password){
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{7,}$";
        return password.matches(regex);
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
    public Map<String, String> inputCompany(UserDTO loginResult) {
        UserDTO loginUserInfo = new UserDTO();
        System.out.print("회사명을 입력하세요 : ");
        String companyName = inputReader.inputString();
        System.out.print("회사전화번호를 입력하세요 : ");
        String companyPhone = inputReader.inputString();
        System.out.print("사업자번호를 입력하세요 : ");
        String companyNum = inputReader.inputString();
        System.out.print("회사주소 입력하세요 : ");
        String companyAddress = inputReader.inputString();

        loginUserInfo = loginResult;

        Map<String, String> map = new HashMap<>();
        map.put("userSeq", String.valueOf(loginUserInfo.getUserSeq()));
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
