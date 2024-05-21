package com.justdo.fruitfruit.model.dto;

import java.sql.Timestamp;
import java.util.Date;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class NotificationDTO {

    private Integer notificationSeq;
    private Integer userSeq;
    private String notificationType;
    private String notificationContent;
    private Integer isRead;
    private Timestamp registerDate;
    private String id;

}
