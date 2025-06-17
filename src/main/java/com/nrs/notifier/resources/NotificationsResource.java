package com.nrs.notifier.resources;

import com.nrs.notifier.dto.NotificationMessage;
import com.nrs.notifier.dto.NotificationResponseDto;
import com.nrs.notifier.notification.service.NotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
public class NotificationsResource {

    private final NotificationService notificationService;

    public NotificationsResource(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping(value = "/send-message", produces = "application/json")
    public ResponseEntity<NotificationResponseDto> sendMessage(@RequestBody final NotificationMessage notificationMessage){
        return ResponseEntity.status(HttpStatus.CREATED).body(notificationService.sendNotification(notificationMessage));
    }
}
