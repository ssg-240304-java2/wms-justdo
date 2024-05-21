package com.justdo.fruitfruit.view;

import com.justdo.fruitfruit.common.constant.Auth;
import com.justdo.fruitfruit.common.constant.NotificationType;
import com.justdo.fruitfruit.common.constant.Status;
import com.justdo.fruitfruit.controller.InputReader;
import com.justdo.fruitfruit.controller.InputReaderFactory;
import com.justdo.fruitfruit.controller.WarehouseController;
import com.justdo.fruitfruit.model.dto.*;

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
                    4. 재고 이동
                    9. 이전으로
                    ==========================""");
            int menu = inputReader.selectMenuNum();
            switch (menu){
                case 1:
                    requestStockSubMenu();
                    break;
                case 2:
                    requestReleeaseSubMenu();
                    break;
                case 3:
                    printStockSubMenu();
                    break;
                case 4:
                    printStockMoveSubMenu();
                    break;
                case 9:
                    System.out.println("이전화면으로 이동합니다.");
                    return;
                default:
                    System.out.println("메뉴를 확인하고 다시 입력해주세요.");
            }
        }while (true);
    }

    private void printStockMoveSubMenu() {
        do {
            System.out.println("""
                    ==========================
                    재 고 이 동
                    ==========================
                    1. 전체 조회
                    2. 입고 조회
                    3. 출고 조회
                    4. 상품 조회
                    9. 이전으로
                    ==========================""");
            int menu = inputReader.selectMenuNum();
            switch (menu){
                case 1:
                    Map<String,String> param= new HashMap<>();
                    param.put("status","0");
                    param.put("productNm",null);
                    warehouseController.printStockMoveList(param);
                    break;
                case 2:
                    param= new HashMap<>();
                    param.put("status","2");
                    param.put("productNm",null);
                    warehouseController.printStockMoveList(param);
                    break;
                case 3:
                    param= new HashMap<>();
                    param.put("status","4");
                    param.put("productNm",null);
                    warehouseController.printStockMoveList(param);
                    break;
                case 4:
                    System.out.print("검색하실 상품명을 입력해주세요 : ");
                    String productNm = inputReader.inputString();
                    param= new HashMap<>();
                    param.put("status","0");
                    param.put("productNm",productNm);
                    warehouseController.printStockMoveList(param);
                    break;
                case 9:
                    return;
                default:
                    System.out.println("메뉴를 확인하고 다시 입력해주세요.");
            }
        }while (true);
    }

    private void printStockSubMenu() {
        do {
            System.out.println("""
                    ==========================
                    창고 재고 확인
                    ==========================
                    1. 전체 조회
                    2. 판매자별 조회
                    3. 상품 별 조회
                    4. 판매자에게 알림 발송
                    9. 이전으로
                    ==========================""");
            int menu = inputReader.selectMenuNum();
            switch (menu){
                case 1:
                    Map<String,String> params = new HashMap<>();
                    params.put("id",null);
                    params.put("productName",null);
                    warehouseController.getStockList(params);
                    break;
                case 2:
                    System.out.print("검색할 판매자 아이디를 입력해주세요.");
                    String id = inputReader.inputString();
                    params = new HashMap<>();
                    params.put("id",id);
                    warehouseController.getStockList(params);
                    break;
                case 3:
                    System.out.print("검색할 상품명을 입력해주세요.");
                    String productName = inputReader.inputString();
                    params = new HashMap<>();
                    params.put("id",null);
                    params.put("productName", productName);
                    warehouseController.getStockList(params);
                    break;
                case 4:
                    List<NotificationDTO> notificationList = addNotificationProduct();
                    warehouseController.addNotificationInfo(notificationList);
                    break;
                case 9:
                    System.out.println("이전화면으로 이동합니다.");
                    return;
                default:
                    System.out.println("메뉴를 확인하고 다시 입력해주세요.");
            }
        }while (true);
    }

    private List<NotificationDTO> addNotificationProduct() {
        List<NotificationDTO> notificationList = new ArrayList<>();
        //while (true){
            // 알림발송이 필요한 상품목록 표시
            List<ProductDTO> notificationProductList =  warehouseController.getNotificationProductList();

            // 알림을 발송할 상품 선택
            System.out.print("목록에서 알림을 발송할 상품번호를 입력해주세요. : ");
            int productNum = inputReader.inputIntValue()-1;
            ProductDTO productDTO = notificationProductList.get(productNum);

            // 알림내용작성
            String content = inputNotificationContent();

            NotificationDTO notificationDTO = new NotificationDTO();
            notificationDTO.setUserSeq(productDTO.getUserSeq());
            notificationDTO.setNotificationType(NotificationType.valueOf(productDTO.getNotificationType()).name());
            notificationDTO.setNotificationContent(content);

            // notificationList에 등록
            notificationList.add(notificationDTO);

//            System.out.println("알림을 보낼 상품을 추가하시겠습니까?(Y/N) : ");
//            String answer = inputReader.inputString().toUpperCase();
//            if("N".equals(answer)){
//                break;
//            }
//        }
        return notificationList;
    }

    private String inputNotificationContent() {

        String content = "";
        System.out.println("알림내용을 작성해주세요.\n입력을 종료하시려면 n을 입력해주세요: ");
        while (true){
            String str = inputReader.inputString();

            if("n".equals(str.toLowerCase())){
                break;
            }else{
                content += str+"\n";
            }
        }
        return content;
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
        //do {

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
//            System.out.print("입고할 상품을 추가하시겠습니까? (Y/N)");
//            String answer = inputReader.inputString().toUpperCase();
//            if("N".equals(answer)){
//                break;
//            }
//        }while (true);

        return inputStockInfoList;
    }

    private List<RequestReleaseDTO> addInputRequestReleaseInfo() {

        List<RequestReleaseDTO> inputReleaseInfoList = new ArrayList<>();
//        do {

            // 출고요청 목록 표시
            List<RequestReleaseDTO> requestReleaseList = warehouseController.getRequestReleaseList();;
            if(requestReleaseList == null || requestReleaseList.isEmpty()){
                return inputReleaseInfoList;
            }

            // 상품번호 입력
            System.out.print("목록에서 출고할 상품번호를 입력해주세요. : ");
            int productNum = inputReader.inputIntValue()-1;
            RequestReleaseDTO productDTO = requestReleaseList.get(productNum);
            productDTO.setProductStatus(Status.RELEASE.ordinal()+1);

            // 리스트 추가
            inputReleaseInfoList.add(productDTO);

//            //계속 등록할건가?
//            System.out.print("출고할 상품을 추가하시겠습니까? (Y/N)");
//            String answer = inputReader.inputString().toUpperCase();
//            if("N".equals(answer)){
//                break;
//            }
//        }while (true);

        return inputReleaseInfoList;
    }

    /**
     * 출고요청의 서브메뉴 표시
     * */
    private void requestReleeaseSubMenu() {

        do{
            System.out.println("""
                    ==========================
                    출 고 요 청 메 뉴
                    ==========================
                    1. 출고요청 목록 보기
                    2. 출고하기
                    9. 이전으로
                    ==========================""");
            int menu = inputReader.selectMenuNum();
            switch (menu){
                case 1:
                    warehouseController.getRequestReleaseList();
                    break;
                case 2:
                    warehouseController.addRequestReleaseList(addInputRequestReleaseInfo());
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
