package com.kaustubh.notification.service;

import com.kaustubh.notification.model.Notification;
import com.kaustubh.notification.model.Status;
import com.kaustubh.notification.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public long createNotification(Notification notification) {
        notification.setStatus(Status.CREATED);
        return this.notificationRepository.insertNotification(notification);
    }

    public List<Notification> searchNotification(String status, int pageSize, int offset) {
        Status statusValue = Status.valueOf(status);
        List<Notification> notifications = this.notificationRepository.findByStatus(statusValue);
        List<Notification> pagedNotifications = new ArrayList<>();
        for(int i = offset; i < Math.min(notifications.size(), offset + pageSize); i++) {
            pagedNotifications.add(notifications.get(i));
        }
        return pagedNotifications;
    }
}
