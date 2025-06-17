package com.nrs.notifier.notification.service;

import com.nrs.notifier.dto.NotificationMessage;
import com.nrs.notifier.dto.NotificationResponseDto;
import com.nrs.notifier.service.KafkaMessageProducerService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationServiceawd {


    private final KafkaMessageProducerService kafkaMessageProducerService;

    public NotificationServiceawd(KafkaMessageProducerService kafkaMessageProducerService) {
        this.kafkaMessageProducerService = kafkaMessageProducerService;
    }

    public NotificationResponseDto sendNotification(final NotificationMessage notificationMessage) {
        
        return new NotificationResponseDto(true, "Success message sent: timestamp: " + LocalDateTime.now());
    }
}