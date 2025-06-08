package com.nrs.notifier.service;

import com.nrs.notifier.dto.NotificationDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageProducerService {

    private final KafkaTemplate<String, NotificationDto> kafkaTemplate;

    public KafkaMessageProducerService(KafkaTemplate<String, NotificationDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(final String topic, final NotificationDto message) {
        kafkaTemplate.send(topic, message);
    }
}
