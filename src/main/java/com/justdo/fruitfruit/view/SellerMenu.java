package com.justdo.fruitfruit.view;

import com.justdo.fruitfruit.controller.InputReader;
import com.justdo.fruitfruit.model.service.CommonService;
import com.justdo.fruitfruit.model.service.SellerService;

public class SellerMenu {
    private static InputReader inputReader = new InputReader();
    private CommonService commonService;
    private String id;
    private SellerService sellerService = new SellerService();
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
                    1. 판매 물품 신청
                    2. 청구금 조회
                    3. 알림 확인
                    9. 뒤로가기
                    =====================
                    """);
            int selectNum = inputReader.selectMenuNum();
            switch (selectNum) {
                case 1:

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
     * 청구금액표 조회 메뉴 화면
     */
    public void BillingMenu(){
        System.out.println("""
                =====================
                청 구 금 
                =====================
                """);

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
