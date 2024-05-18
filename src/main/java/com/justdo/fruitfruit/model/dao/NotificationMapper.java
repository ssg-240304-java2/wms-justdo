package com.justdo.fruitfruit.model.dao;

import com.justdo.fruitfruit.model.dto.NotificationDTO;

import java.util.List;
import java.util.Map;

public interface NotificationMapper {

    List<NotificationDTO> selectAllNotification(Map<String,String> criteria);

    int modifyNotification(Map<String, String> criteria);
}
