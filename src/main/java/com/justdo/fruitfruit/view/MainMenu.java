package com.justdo.fruitfruit.view;

import com.justdo.fruitfruit.controller.InputReader;
import com.justdo.fruitfruit.controller.InputReaderFactory;
import com.justdo.fruitfruit.controller.UserController;
import com.justdo.fruitfruit.controller.WarehouseController;

public class MainMenu {

    private InputReader inputReader = InputReaderFactory.getInputReader();
    private UserController userController = new UserController();
    private UserMenu userMenu = new UserMenu();
    private WarehouseController warehouseController = new WarehouseController();


    public void mainMenuView(){
        do {
            System.out.println("""
                =====================
                메 인 메 뉴
                =====================
                1. 로그인
                2. 회원가입
                3. 상품목록 표시
                4. 아이디 찾기
                5. 비밀번호 찾기
                9. 종료
                =====================""");
            int menu  = inputReader.selectMenuNum();
            switch (menu){
                case 1: //로그인
                    userController.loginUser(userMenu.inputLogin());
                    break;
                case 2: // 회원가입
                    userController.insertUser(userMenu.inputUser());
                    break;
                case 3: // 상품목록 표시
                    userMenu.searchProductMenu();
                    break;
                case 4: // 아이디 찾기
                    userMenu.findMyIdMenu();
                    break;
                case 5: // 비밀번호 찾기
//                    userMenu.findUserPassword();
                    break;
                case 9:
                    inputReader.close();
                    System.out.println("시스템이 종료되었습니다.");
                    return;
                default:
                    System.out.println("메뉴번호를 다시 선택해 주세요.");
            }
        }while(true);
    }


}
