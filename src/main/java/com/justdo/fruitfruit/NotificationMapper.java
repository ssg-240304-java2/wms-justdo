package com.justdo.fruitfruit;

import com.justdo.fruitfruit.model.dto.NotificationDTO;

import java.util.List;

public interface NotificationMapper {

    List<NotificationDTO> selectAllNotification(String id);

    int modifyNotification(String id);
}
