package com.kaustubh.notification.service;

import com.kaustubh.notification.model.Notification;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationSender implements NotificationSender{
    @Override
    public boolean send(Notification notification) {
        System.out.println("Sent notification with id: " + notification.getId());
        return true;
    }
}
