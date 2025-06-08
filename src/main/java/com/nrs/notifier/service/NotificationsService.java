package com.nrs.notifier.service;

import com.nrs.notifier.dto.NotificationDto;
import com.nrs.notifier.dto.NotificationResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationsService {

    @Value("${notifications.kafka.topic}")
    private String notificationsKafkaTopic;

    private final KafkaMessageProducerService kafkaMessageProducerService;

    public NotificationsService(KafkaMessageProducerService kafkaMessageProducerService) {
        this.kafkaMessageProducerService = kafkaMessageProducerService;
    }

    public NotificationResponseDto sendNotification(final NotificationDto notificationDto) {
        kafkaMessageProducerService.sendMessage(notificationsKafkaTopic, notificationDto);
        return new NotificationResponseDto(true, "Success message sent: timestamp: " + LocalDateTime.now());
    }
}