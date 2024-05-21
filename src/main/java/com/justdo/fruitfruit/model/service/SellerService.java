package com.justdo.fruitfruit.model.service;

import com.justdo.fruitfruit.model.dto.NotificationDTO;
import com.justdo.fruitfruit.model.dto.OrderDTO;
import com.justdo.fruitfruit.model.dao.BillingMapper;
import com.justdo.fruitfruit.model.dao.NotificationMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.justdo.fruitfruit.common.MyBatisTemplate.getSqlSession;

public class SellerService {
    private NotificationMapper notificationMapper;
    private BillingMapper billingMapper;

    /***
     * 판매자의 알림 목록 조회
     * @param id 현재 계정의 아이디
     */
    public void selectAllNotification(String id){

        SqlSession sqlSession = getSqlSession();
        notificationMapper = sqlSession.getMapper(NotificationMapper.class);
        Map<String, String> criteria = new HashMap<>();
        criteria.put("userid", id);

        List<NotificationDTO> notificationList = notificationMapper.selectAllNotification(criteria);

        if (notificationList != null && notificationList.size() > 0) {
            for (NotificationDTO notification : notificationList) {
                System.out.println("[" + notification.getNotificationType() + " ] " + notification.getNotificationContent());
            }
        } else {
            System.out.println("새로운 알림이 없습니다.");
        }
        sqlSession.close();
    }

    /***
     * 판매자 알림 읽음 처리
     * @param id
     * 판매자가 읽은 알림을 read 처리하여 다음 열람시 안뜨게 하는 메소드
     */
    public void updateNotification(String id){
        SqlSession sqlSession = getSqlSession();
        notificationMapper = sqlSession.getMapper(NotificationMapper.class);
        Map<String, String> criteria = new HashMap<>();
        criteria.put("userid", id);


        try{
            int result = notificationMapper.modifyNotification(criteria);
            sqlSession.commit();
        }catch (Exception e){
            System.out.println("알림 확인 실패");
            sqlSession.rollback();
        }finally {
            sqlSession.close();
        }
    }

    /***
     * 명세서 출력 메소드
     * @param id
     * 판매자의 수익금액과 납부 수수료 출력
     */
    public void selectAllBillingAmount(String id) {
        SqlSession sqlSession = getSqlSession();
        billingMapper = sqlSession.getMapper(BillingMapper.class);

        Map<String, String> criteria = new HashMap<>();
        criteria.put("userid", id);
        int total = 0;
        List<OrderDTO> orderList = billingMapper.BillingAmount(criteria);
        if (orderList != null && orderList.size() > 0) {
            for (OrderDTO order : orderList) {
                total += order.getTotalPrice();
            }
            System.out.println("판매 수익 : " + total + " 수수료 : " + total * 0.05);
        }else{
            System.out.println("아직 판매 이력이 없습니다.");
        }
        sqlSession.close();
    }
}
