package com.kaustubh.notification.repository;

import com.kaustubh.notification.model.Notification;
import com.kaustubh.notification.model.Status;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Service
public class NotificationRepository {
    private final Map<Long, Notification> notificationStore = new ConcurrentHashMap<>();
    private long idCounter = 1L;

    public Notification findNotificationById(long id) {
        return notificationStore.get(id);
    }

    public long insertNotification(Notification notification) {
        notification.setId(idCounter++);
        this.notificationStore.put(notification.getId(), notification);
        return notification.getId();
    }

    public List<Notification> findByStatus(Status status) {
        List<Notification> notifications = new ArrayList<>();
        for (Map.Entry<Long, Notification> entry : notificationStore.entrySet()) {
            if(entry.getValue().getStatus().equals(status))
                notifications.add(entry.getValue());

        }
        notifications.sort(new Comparator<Notification>() {

            @Override
            public int compare(Notification o1, Notification o2) {
                return o1.getId() < o2.getId()? -1 : 1;
            }
        });
        return notifications;
    }
}
