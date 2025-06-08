package com.nrs.notifier.resources;

import com.nrs.notifier.dto.NotificationDto;
import com.nrs.notifier.dto.NotificationResponseDto;
import com.nrs.notifier.service.NotificationsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
public class NotificationsResource {

    private final NotificationsService notificationsService;

    public NotificationsResource(NotificationsService notificationsService) {
        this.notificationsService = notificationsService;
    }

    @PostMapping(value = "/send-message", produces = "application/json")
    public ResponseEntity<NotificationResponseDto> sendMessage(@RequestBody final NotificationDto notificationDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(notificationsService.sendNotification(notificationDto));
    }
}
