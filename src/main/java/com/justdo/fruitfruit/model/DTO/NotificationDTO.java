package com.justdo.fruitfruit.model.DTO;

import java.util.Date;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class NotificationDTO {

    private int notificationSeq;
    private int userSeq;
    private int notificationType;
    private String notificationContent;
    private boolean isRead;
    private Date registerDate;
    private String id;

}
