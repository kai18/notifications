package com.kaustubh.notification.controller;

import com.kaustubh.notification.service.NotificationSendingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notification/{id}/")
public class NotificationSendingController {
    private final NotificationSendingService notificationSendingService;

    public NotificationSendingController(NotificationSendingService notificationSendingService) {
        this.notificationSendingService = notificationSendingService;
    }

    @PostMapping("send")
    public ResponseEntity<Boolean> sendNotification(@PathVariable("id") Long id) {
        boolean status = this.notificationSendingService.send(id);
        return ResponseEntity.ok().body(status);
    }
}
