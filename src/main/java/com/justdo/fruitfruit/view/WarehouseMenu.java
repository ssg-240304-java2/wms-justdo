package com.justdo.fruitfruit.view;

import com.justdo.fruitfruit.controller.InputReader;
import com.justdo.fruitfruit.controller.InputReaderFactory;
import com.justdo.fruitfruit.controller.WarehouseController;

public class WarehouseMenu {

    private InputReader inputReader = InputReaderFactory.getInputReader();
    private WarehouseController warehouseController = new WarehouseController();

    public void warehouseMainMenu(){
        do{
            System.out.println("""
                    ==========================
                    창 고 관 리 자 메 뉴
                    ==========================
                    1. 입고요청 목록
                    2. 출고요청 목록
                    3. 창고 재고 확인
                    4. 재고 이동 목록
                    9. 이전으로
                    ==========================""");
            int menu = inputReader.selectMenuNum();
            switch (menu){
                case 1:
                    warehouseController.getRequestStockList();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 9:
                    System.out.println("이전화면으로 이동합니다.");
                    return;
                default:
                    System.out.println("메뉴를 확인하고 다시 입력해주세요.");
            }
        }while (true);
    }
}
