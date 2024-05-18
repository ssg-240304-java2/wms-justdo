package com.justdo.fruitfruit.view;

import com.justdo.fruitfruit.controller.InputReader;
import com.justdo.fruitfruit.controller.InputReaderFactory;
import com.justdo.fruitfruit.controller.WarehouseController;

public class MainMenu {

    private InputReader inputReader = InputReaderFactory.getInputReader();
    private WarehouseController warehouseControlle = new WarehouseController();


    public void mainMenuView(){
        do {
            System.out.println("""
                =====================
                메 인 메 뉴
                =====================
                1. 로그인
                2. 회원가입
                3. 상품목록 표시
                9. 종료
                =====================""");
            int menu  = inputReader.selectMenuNum();
            switch (menu){
                case 1: //로그인
                    new WarehouseMenu().warehouseMainMenu();
                    break;
                case 2: // 회원가입
                    break;
                case 3: // 상품목록 표시
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
