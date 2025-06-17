package com.nrs.notifier.notification.service;

import com.nrs.notifier.dto.NotificationMessage;
import com.nrs.notifier.notification.service.enm.NotificationType;
import com.nrs.notifier.service.KafkaMessageProducerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationService {
    
    @Value("${notifications.kafka.topic}")
    private String notificationsKafkaTopic;
    
    private final KafkaMessageProducerService kafkaMessageProducerService;

    public EmailNotificationService(KafkaMessageProducerService kafkaMessageProducerService) {
        this.kafkaMessageProducerService = kafkaMessageProducerService;
    }

    @Override
    public void send(final NotificationMessage notificationMessage) {
        kafkaMessageProducerService.sendMessage(notificationsKafkaTopic, NotificationType.EMAIL.getId(), notificationMessage);
    }
}
