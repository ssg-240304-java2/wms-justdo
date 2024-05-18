package com.justdo.fruitfruit.view;

import com.justdo.fruitfruit.common.constant.Auth;
import com.justdo.fruitfruit.common.constant.Status;
import com.justdo.fruitfruit.controller.InputReader;
import com.justdo.fruitfruit.controller.InputReaderFactory;
import com.justdo.fruitfruit.controller.WarehouseController;
import com.justdo.fruitfruit.model.dto.GradeDTO;
import com.justdo.fruitfruit.model.dto.ProductDTO;
import com.justdo.fruitfruit.model.dto.SectorDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WarehouseMenu {

    private InputReader inputReader = InputReaderFactory.getInputReader();
    private WarehouseController warehouseController = new WarehouseController();

    /**
     * 창고관리자 전용메뉴 뷰
     * */
    public void warehouseMainMenu(){
        do{
            System.out.println("""
                    ==========================
                    창 고 관 리 자 메 뉴
                    ==========================
                    1. 입고요청
                    2. 출고요청
                    3. 창고 재고 확인
                    4. 재고 이동 목록
                    9. 이전으로
                    ==========================""");
            int menu = inputReader.selectMenuNum();
            switch (menu){
                case 1:
                    requestStockSubMenu();
                    break;
                case 2:
                    requestReleeaseSubMenu();
                    warehouseController.getRequestReleaseList();
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


    /**
     * 입고요청 서브메뉴 표시
     * */
    private void requestStockSubMenu() {
        do{
            System.out.println("""
                    ==========================
                    입 고 요 청 메 뉴
                    ==========================
                    1. 입고요청 목록 보기
                    2. 입고하기
                    9. 이전으로
                    ==========================""");
            int menu = inputReader.selectMenuNum();
            switch (menu){
                case 1:
                    warehouseController.getRequestStockList();
                    break;
                case 2:
                    warehouseController.addRequestStockList(addInputRequestInfo());
                    break;
                case 9:
                    System.out.println("이전화면으로 이동합니다.");
                    return;
                default:
                    System.out.println("메뉴를 확인하고 다시 입력해주세요.");
            }
        }while (true);
    }

    private List<ProductDTO> addInputRequestInfo() {

        List<ProductDTO> inputStockInfoList = new ArrayList<>();
        do {

            // 입고요청 목록 표시
            List<ProductDTO> requestStockList = warehouseController.getRequestStockList();
            if(requestStockList == null || requestStockList.isEmpty()){
                return inputStockInfoList;
            }

            // 상품번호 입력
            System.out.print("목록에서 입고할 상품번호를 입력해주세요. : ");
            int productNum = inputReader.inputIntValue()-1;
            ProductDTO productDTO = requestStockList.get(productNum);

            // 등급 목록 표시
            List<GradeDTO> gradeList = warehouseController.getGradeList(productDTO.getCategorySeq());

            // 등급 선택
            System.out.print("설정할 등급번호를 입력해 주세요. : ");
            int gradeNum = inputReader.inputIntValue()-1;
            GradeDTO gradeDTO = gradeList.get(gradeNum);

            // 창고 목록 표시
            List<SectorDTO> sectorList =  warehouseController.getSectorList(productDTO.getProductAmount());

            // 창고 선택
            System.out.print("상품을 위치시킬 창고구역 번호를 입력해 주세요. : ");
            int sectorNum = inputReader.inputIntValue()-1;
            SectorDTO sectorDTO = sectorList.get(sectorNum);

            // productDTO설정
            productDTO.setGradeSeq(gradeDTO.getGradeSeq());
            productDTO.setSectorSeq(sectorDTO.getSectorSeq());
            productDTO.setProductStatus(Status.STOCK.ordinal()+1);
            // 리스트 추가
            inputStockInfoList.add(productDTO);

            //계속 등록할건가?
            System.out.print("입고할 상품을 추가하시겠습니까? (Y/N)");
            String answer = inputReader.inputString().toUpperCase();
            if("N".equals(answer)){
                break;
            }
        }while (true);

        return inputStockInfoList;
    }


    /**
     * 출고요청의 서브메뉴 표시
     * */
    private void requestReleeaseSubMenu() {

    }
}
