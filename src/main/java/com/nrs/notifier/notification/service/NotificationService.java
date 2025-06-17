package com.nrs.notifier.notification.service;

import com.nrs.notifier.dto.NotificationMessage;
import com.nrs.notifier.dto.NotificationResponseDto;
import com.nrs.notifier.notification.service.enm.NotificationType;
import com.nrs.notifier.service.KafkaMessageProducerService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationService {

    private final SendNotificationFactory factory;

    public NotificationService(SendNotificationFactory factory) {
        this.factory = factory;
    }

    public NotificationResponseDto sendNotification(final NotificationMessage notificationMessage) {
        final var notificationType = NotificationType.fromString(notificationMessage.getType());
        final var notificationService = factory.createNotificationService(notificationType);
        notificationService.send(notificationMessage);

        return new NotificationResponseDto(true, "Success message sent: timestamp: " + LocalDateTime.now());
    }
}