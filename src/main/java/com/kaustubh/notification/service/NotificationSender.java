package com.kaustubh.notification.service;

import com.kaustubh.notification.model.Notification;

public interface NotificationSender {
    boolean send(Notification notification);
}
