package com.justdo.fruitfruit.view;

import com.justdo.fruitfruit.controller.CategoryController;
import com.justdo.fruitfruit.controller.InputReader;
import com.justdo.fruitfruit.controller.ProductController;
import com.justdo.fruitfruit.model.dto.UserDTO;
import com.justdo.fruitfruit.model.service.CommonService;
import com.justdo.fruitfruit.model.service.SellerService;

import java.util.HashMap;
import java.util.Map;

public class SellerMenu {
    private static InputReader inputReader = new InputReader();
    private CommonService commonService;
    private String id;
    private UserDTO userDTO;
    private ProductController productController;
    private SellerService sellerService = new SellerService();
    CategoryController categoryController = new CategoryController();

    public SellerMenu(UserDTO loginresult) {
        this.userDTO = loginresult;
        this.productController = new ProductController();
        this.productController.setUserDTO(loginresult);
    }

    /***
     * 판매자 메인 메뉴
     */
    public void SellerMenuView(){
        commonService = new CommonService();
        id = commonService.getId();
        while(true) {
            System.out.println("""
                    =====================
                    판 매 자 메 인 메 뉴
                    =====================
                    1. 판매 물품 관리
                    2. 청구금 조회
                    3. 알림 확인
                    9. 뒤로가기
                    =====================
                    """);
            int selectNum = inputReader.selectMenuNum();
            switch (selectNum) {
                case 1:
                manageProduct();
                    break;
                case 2:
                BillingMenu();
                    break;
                case 3:
                NotificationMenu();
                    break;
                case 9:
                    return;
                default:
                    break;
            }
        }
    }

    /***
     * 판매 상품 관리창 메뉴
     * */
    public void manageProduct() {
        while (true) {
            System.out.print("""
                    ============================
                    판매 상품 관리창입니다.
                    ============================
                    1. 내 물품 조회
                    2. 신규 등록
                    3. 물품 수정
                    4. 물품 삭제
                    9. 돌아가기
                    원하는 메뉴의 숫자를 눌러주세요
                    """);
            int num = inputReader.selectMenuNum();
            switch (num) {
                case 1:
                    productController.selectAllProduct(); break;
                case 2:
                    productController.registerProduct(registerProduct());; break;
                case 3:
                    productController.modifyProduct(modifyProduct()); break;
                case 4:
                    productController.deleteProduct(selectProduct()); break;
                case 9:
                    return;
                default:
                    break;
            }
        }
    }

    /*
     * 물품 선택
     * */
    private Map<String, String> selectProduct() {
        while (true) {
            System.out.println("선택할 상품의 코드 번호를 입력해주세요");
            String productSeq = inputReader.inputString();

            Map<String, String> parameter = new HashMap<>();

            parameter.put("productSeq", productSeq);

            return parameter;
        }
    }

    /*
     * 물품 수정 뷰
     * */
    private Map<String, String> modifyProduct() {
        while (true) {
            System.out.print("""
                    ============================
                    등록 물품 수정하겠습니다.
                    ============================
                    """);
            System.out.println("수정할 상품의 물품 번호를 입력해주세요");
            String code = inputReader.inputString();
            System.out.println("수정할 상품명을 입력해주세요");
            String productName = inputReader.inputString();
            System.out.println("수정할 가격을 입력해주세요");
            String productPrice = inputReader.inputString();
            System.out.println("수정할 수량을 입력해주세요");
            String productAmount = inputReader.inputString();
            System.out.println("수정할 무게를 입력해주세요");
            String productWeight = inputReader.inputString();

            Map<String, String> parameter = new HashMap<>();

            parameter.put("productSeq", code);
            parameter.put("productName", productName);
            parameter.put("productPrice", productPrice);
            parameter.put("productAmount", productAmount);
            parameter.put("productWeight", productWeight);

            return parameter;
        }
    }

    /*
     * 물품 등록 뷰
     * */
    public Map<String, String> registerProduct() {
        Map<String, String> parameter = new HashMap<>();
        // chooseCategory 메서드 호출 및 결과를 parameter에 병합
        Map<String, String> categoryParameter = chooseCategory();
        parameter.putAll(categoryParameter);

        while (true) {
            System.out.print("""
                    ============================
                    판매를 위한 물품 등록창입니다.
                    ============================
                    """);
            System.out.println("상품명을 입력해주세요");
            String productName = inputReader.inputString();
            System.out.println("가격을 입력해주세요");
            String productPrice = inputReader.inputString();
            System.out.println("수량을 입력해주세요");
            String productAmount = inputReader.inputString();
            System.out.println("무게를 입력해주세요");
            String productWeight = inputReader.inputString();

            parameter.put("productName", productName);
            parameter.put("productPrice", productPrice);
            parameter.put("productAmount", productAmount);
            parameter.put("productWeight", productWeight);

            return parameter;
        }
    }

    /***
     * 등록 가능 물품 카테고리 view 및 선택
     * */
    public Map<String, String> chooseCategory(){
        while (true) {
            System.out.print("""
                    ============================
                    등록 가능 물품 카테고리
                    ============================
                    """);
            categoryController.selectAllCategory();
            System.out.println("등록할 물품의 카테고리 번호를 입력해주세요");
            String productCategory = inputReader.inputString();

            Map<String, String> parameter = new HashMap<>();

            parameter.put("productCategory", productCategory);

            return parameter;

        }
    }

    /***
     * 청구금액표 조회 메뉴 화면
     */
    public void BillingMenu(){
            System.out.println("""
                    =====================
                    청 구 영 수 증
                    =====================
                    """);
            sellerService.selectAllBillingAmount(this.id);
            return;
        }
    /***
     * 알림 목록 확인
     */
    public void NotificationMenu(){
        System.out.println("""
                =====================
                알 림 목 록
                =====================
                """);
        sellerService.selectAllNotification(this.id);
        sellerService.updateNotification(this.id);
        return;
    }
}
