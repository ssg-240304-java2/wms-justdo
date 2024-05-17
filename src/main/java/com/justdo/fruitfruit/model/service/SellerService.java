package com.justdo.fruitfruit.model.service;

import com.justdo.fruitfruit.NotificationMapper;
import com.justdo.fruitfruit.model.dto.NotificationDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.justdo.fruitfruit.common.MyBatisTemplate.getSqlSession;

public class SellerService {
    private NotificationMapper notificationMapper;

    /***
     * 판매자의 알림 목록 조회
     * @param id 현재 계정의 아이디
     */
    public void selectAllNotification(String id){

        SqlSession sqlSession = getSqlSession();
        notificationMapper = sqlSession.getMapper(NotificationMapper.class);


        List<NotificationDTO> notificationList = notificationMapper.selectAllNotification(id);

        if (notificationList != null && notificationList.size() > 0) {
            for (NotificationDTO notification : notificationList) {
                System.out.println("[" + notification.getNotificationType() + " ] " + notification.getNotificationContent());
            }
        } else {
            System.out.println("새로운 알림이 없습니다.");
        }
        sqlSession.close();
    }

    public void updateNotification(String id){
        SqlSession sqlSession = getSqlSession();
        notificationMapper = sqlSession.getMapper(NotificationMapper.class);


        int result = notificationMapper.modifyNotification(id);
        if (result > 0) {
            System.out.println("알림을 확인 했습니다."); // 확인용 마지막 제출땐 삭제
            sqlSession.commit();
        }else{
            System.out.println("알림 확인 실패");
            sqlSession.rollback();
        }
        sqlSession.close();
    }

}
