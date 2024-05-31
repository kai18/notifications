package com.kaustubh.notification.service;

import com.kaustubh.notification.model.Notification;
import com.kaustubh.notification.model.Status;
import com.kaustubh.notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;

@Service
public class NotificationSendingService {
    private final NotificationRepository notificationRepository;
    private final NotificationSenderFactory notificationSenderFactory;

    public NotificationSendingService(NotificationRepository notificationRepository, NotificationSenderFactory notificationSenderFactory) {
        this.notificationRepository = notificationRepository;
        this.notificationSenderFactory = notificationSenderFactory;
    }

    public boolean send(long notificationId) {
        Notification notification = notificationRepository.findNotificationById(notificationId);

        if(notification == null)
            throw new NotificationNotFoundException("Notification with id " + notificationId + " not found");

        boolean status =  this.notificationSenderFactory.getNotificationSender(notification.getNotificationType()).send(notification);
        if(status)
            notification.setStatus(Status.SENT);
        else{
            notification.setStatus(Status.FAILED);
        }
        return status;
    }
}
