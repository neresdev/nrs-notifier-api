package com.nrs.notifier.notification.service;

import com.nrs.notifier.notification.service.enm.NotificationType;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SendNotificationFactory {
    private final ApplicationContext applicationContext;

    public SendNotificationFactory(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public SendNotificationService createNotificationService(final NotificationType notificationType) {
        if (notificationType == NotificationType.EMAIL) {
            return (SendNotificationService) applicationContext.getBean("emailSendNotificationService");
        }
        throw new IllegalArgumentException("Notification Type not implemented yet: " + notificationType);
    }
}
