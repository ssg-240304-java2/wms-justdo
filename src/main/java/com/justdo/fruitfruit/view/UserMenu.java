package com.justdo.fruitfruit.view;

import com.justdo.fruitfruit.common.constant.Auth;
import com.justdo.fruitfruit.controller.*;
import com.justdo.fruitfruit.model.dto.UserDTO;
import com.justdo.fruitfruit.model.service.UserService;

import java.util.HashMap;
import java.util.Map;

public class UserMenu {

    private final InputReader inputReader = InputReaderFactory.getInputReader();
    private final ProductController productController = new ProductController();
    private final CategoryController categoryController = new CategoryController();
    private final CompanyController companyController = new CompanyController();

    private String id = null;
    private UserService userService = new UserService();
    /***
     * 구매자 뷰 출력하는 메서드
     * @param loginResult 로그인된 회원 정보
     */
    public void consumerMenuView(UserDTO loginResult) {
        id = loginResult.getId();
        while (true) {
            String menu = ("""
                    ================================
                    구 매 자 메 뉴
                    ================================
                    1. 물품 조회
                    2. 장바구니 조회
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
                case 2: userService.viewCart(id);
                    break;
                case 3:
                    companyController.insertCompany(inputCompany(loginResult)); // 판매자 전환
                    break;
                case 9:
                    System.out.println("로그아웃이 완료되었습니다.");
                    id = null;
                    return;
                default:
                    System.out.println("잘못된 메뉴를 선택하셨습니다. 다시 입력해주세요.");
            }
        }
    }

    public void cartMenu(){
        while(true) {
            System.out.println("""
                    ================================
                    쇼 핑 선 택
                    ================================
                    1. 장바구니 담기
                    2. 장바구니 조회
                    3. 장바구니 수정
                    3. 결제하기
                    9. 뒤로가기
                    ================================
                    """);
            int number = inputReader.selectMenuNum();
            switch (number) {
                case 1: addCartMenu(); break;
                case 2: userService.viewCart(id); break;
                case 3: modifyMenu(); break;
//                case 4: payingMenu(); break;
                case 9: return;
                default: break;
            }
        }
    }


    private void modifyMenu() {
        while (true) {
            userService.viewCart(id);
            System.out.println("""
                    ================================
                    장 바 구 니 수 정
                    ================================
                    1. 수량 수정
                    2. 전체 삭제
                    9. 뒤로가기
                    ================================
                    """);
            int number = inputReader.selectMenuNum();
            switch (number) {
                case 1: modifyQuantityMenu(); break;
                case 2: userService.deleteAllCart(id); break;
                case 9: return;
                default: break;
            }
        }
    }

    private void modifyQuantityMenu() {
        System.out.print("수량 변경 할 제품 번호를 적어주세요 : ");
        int productNum = inputReader.inputIntValue();
        System.out.print("변경할 값을 적어주세요 : ");
        int quantity = inputReader.inputAmout();
        userService.modifyQuantity(id, productNum, quantity);
    }



    public void addCartMenu() {
        String menu = ("""
                ================================
                목 록 선 택
                ================================
                """);
        System.out.println(menu);
        while (true) {
            System.out.print("담을 상품번호를 입력해 주세요 : ");
            int choice = inputReader.inputIntValue();
            System.out.print("상품 수량을 입력해 주세요 : ");
            int count = inputReader.inputIntValue();
            userService.addCart(id, choice, count);
            System.out.print("계속 쇼핑하시겠습니까? (예 : 1 / 아니오 : 2) : ");
            int number = inputReader.inputIntValue();
            switch (number) {
                case 1:
                    break;
                case 2:
                    return;
                default:
                    System.out.println("숫자를 잘못 입력했습니다.");
                    break;
            }
        }
    }


    /***
     * 상품 조회뷰 출력하는 메서드
     */
    public void searchProductMenu() {
        while (true) {
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
                    if(id != null) {
                        cartMenu();
                    }
                    break;
                case 2:
                    categoryController.selectAllCategory();
                    productController.selectAllProductByCategory(inputCategoryNum());
                    if(id != null) {
                        cartMenu();
                    }
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
    public boolean isValidPassword(String password) {
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


    /***
     * 회원의 이름과 휴대폰번호를 리턴하는 함수
     * @return 입력받은 회원 이름 회원 핸드폰번호 반환
     */
    public Map<String, String> inputFindId() {
        System.out.print("가입하신 계정의 이름을 입력하세요 : ");
        String name = inputReader.inputString();
        System.out.print("가입하신 계정의 휴대폰번호를 입력하세요 : ");
        String phone = inputReader.inputString();

        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("phone", phone);

        return map;

    }


    /***
     * 입력한 아이디와 이름 휴대폰번호를 리턴하는 함수
     * @return 입력받은 아이디와 이름 휴대폰번호 반환
     */
    public Map<String, String> inputFindUserPassword() {
        System.out.print("가입하신 계정의 아이디를 입력하세요 : ");
        String id = inputReader.inputString();
        System.out.print("가입하신 계정의 이름 입력하세요 : ");
        String name = inputReader.inputString();
        System.out.print("가입하신 계정의 휴대폰번호 입력하세요 : ");
        String phone = inputReader.inputString();

        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("phone", phone);

        return map;

    }

    /***
     * 비밀번호 재설정 메서드
     * @return 재설정한 비밀번호
     */
    public Map<String, String> inputNewPassword() {
        boolean isValidPassword = false;
        String password;

        do {
            System.out.println("""
                    ================================
                    비 밀 번 호 재 설 정
                    ================================""");
            System.out.print("비밀번호 : ");
            password = inputReader.inputString();

            isValidPassword = isValidPassword(password);
            if (!isValidPassword) {
                System.out.println("비밀번호는 최소 8자리 / 1개 이상의 숫자, 영문 대소문자, 특수 기호를 포함해야 합니다.");
                System.out.println("다시 입력해주세요.\n");
            }
        } while (!isValidPassword);
        Map<String, String> map = new HashMap<>();
        map.put("password", password);
        return map;
    }


}
