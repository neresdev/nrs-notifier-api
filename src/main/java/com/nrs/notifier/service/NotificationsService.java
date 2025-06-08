package com.nrs.notifier.service;

import com.nrs.notifier.dto.NotificationDto;
import com.nrs.notifier.dto.NotificationsResponseDto;
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

    public NotificationsResponseDto sendNotification(final NotificationDto notificationDto) {
        kafkaMessageProducerService.sendMessage(notificationsKafkaTopic, notificationDto);
        return new NotificationsResponseDto(true, "Success message sent: timestamp: " + LocalDateTime.now());
    }
}