package com.nrs.notifier.resources;

import com.nrs.notifier.dto.NotificationDto;
import com.nrs.notifier.dto.NotificationsResponseDto;
import com.nrs.notifier.service.NotificationsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequestMapping
@RestController
public class NotificationsResource {

    private final NotificationsService notificationsService;

    public NotificationsResource(NotificationsService notificationsService) {
        this.notificationsService = notificationsService;
    }

    @PostMapping("/send-message")
    public ResponseEntity<String> teste(/*@RequestBody final NotificationDto notificationDto*/){ // todo  verificar erro 406 not acceptable
        notificationsService.sendNotification(new NotificationDto("EMAIL", "teste@email.com", "mensagem as " + LocalDateTime.now()));
        return ResponseEntity.ok("a");
    }
}
