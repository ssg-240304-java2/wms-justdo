package com.justdo.fruitfruit;

import com.justdo.fruitfruit.model.DTO.NotificationDTO;

import java.util.List;
import java.util.Map;

public interface NotificationMapper {

    List<NotificationDTO> selectAllNotification(String id);

    int modifyNotification(String id);
}
