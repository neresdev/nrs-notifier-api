package com.nrs.notifier.notification.service;

import com.nrs.notifier.dto.NotificationMessage;
import com.nrs.notifier.notification.service.enm.NotificationType;
import com.nrs.notifier.service.KafkaMessageProducerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailSendNotificationService implements SendNotificationService {
    
    @Value("${email.notifications.kafka.topic}")
    private String emailTopic;
    
    private final KafkaMessageProducerService kafkaMessageProducerService;

    public EmailSendNotificationService(KafkaMessageProducerService kafkaMessageProducerService) {
        this.kafkaMessageProducerService = kafkaMessageProducerService;
    }

    @Override
    public void send(final NotificationMessage notificationMessage) {
        kafkaMessageProducerService.sendMessage(emailTopic, notificationMessage);
    }
}
