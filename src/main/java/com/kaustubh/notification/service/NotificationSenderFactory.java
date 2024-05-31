package com.kaustubh.notification.service;

import org.springframework.stereotype.Component;

@Component
public class NotificationSenderFactory {
    private final EmailNotificationSender emailNotificationSender;


    public NotificationSenderFactory(EmailNotificationSender emailNotificationSender) {
        this.emailNotificationSender = emailNotificationSender;
    }

    public NotificationSender getNotificationSender(NotificationType type) {
        if(type.equals(NotificationType.EMAIL))
            return emailNotificationSender;

        throw new IllegalArgumentException("Invalid notification type");
    }

}
