package com.justdo.fruitfruit.view;

import com.justdo.fruitfruit.controller.InputReader;
import com.justdo.fruitfruit.controller.InputReaderFactory;
import com.justdo.fruitfruit.controller.ProductController;
import com.justdo.fruitfruit.controller.UserController;

public class MainMenu {
    private InputReader inputReader = InputReaderFactory.getInputReader();
    private UserController userController = new UserController();
    private UserMenu userMenu = new UserMenu();
    private ProductController productController = new ProductController();

    public void MainMenuView() {

        while (true) {
            String menu = ("""
                    =====================
                                    
                        프리미엄 과일 상점
                        🍎FRUITFRUIT🍎
                                    
                    =====================
                    1. 상품목록
                    2. 로그인
                    3. 회원가입
                    9. 종료
                    =====================""");
            System.out.println(menu);
            int choice = inputReader.selectMenuNum();

            switch (choice) {
                case 1:
                    userMenu.searchProductMenu();
                    break;
                case 2:
                    userController.loginUser(userMenu.inputLogin());
                    break;
                case 3:
                    userController.insertUser(userMenu.inputUser());
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    InputReaderFactory.getInputReader().close();
                    return;
                default:
                    System.out.println("잘못된 메뉴를 선택하셨습니다. 다시 입력해주세요.");
            }

        }
    }
}
