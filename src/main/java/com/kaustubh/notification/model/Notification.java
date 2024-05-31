package com.kaustubh.notification.model;

import com.kaustubh.notification.service.NotificationType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Notification {
    private long id;
    private BigDecimal currentPrice;
    private BigDecimal dailyPriceChange;
    private Long dailyPriceVolume;
    private NotificationType notificationType;
    private Status status;
    private List<String> recepientIds;
}
