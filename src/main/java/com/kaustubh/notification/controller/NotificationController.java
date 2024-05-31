package com.kaustubh.notification.controller;

import com.kaustubh.notification.model.Notification;
import com.kaustubh.notification.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/notification")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping()
    public ResponseEntity<Long> createNotification(@RequestBody Notification notification) {
        long id = this.notificationService.createNotification(notification);
        return ResponseEntity.ok(id);
    }
    @GetMapping()
    public ResponseEntity<List<Notification>> searchNotifications(@RequestParam("status") String status,
                                                                  @RequestParam("pageSize") int pageSize,
                                                                  @RequestParam("offset") int offset) {
        List<Notification> notifications = this.notificationService.searchNotification(status, pageSize, offset);
        return ResponseEntity.ok(notifications);
    }
}
