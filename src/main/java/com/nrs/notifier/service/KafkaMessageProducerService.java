package com.nrs.notifier.service;

import com.nrs.notifier.dto.NotificationMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class KafkaMessageProducerService {

    private final KafkaTemplate<String, NotificationMessage> kafkaTemplate;

    public KafkaMessageProducerService(KafkaTemplate<String, NotificationMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(final String topic, final int partition, final NotificationMessage message) {
        kafkaTemplate.send(topic, partition, UUID.randomUUID().toString(), message);
    }
}
