package com.nrs.notifier.notification.service;

import com.nrs.notifier.notification.service.enm.NotificationType;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class NotificationFactory {
    private final ApplicationContext applicationContext;

    public NotificationFactory(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public NotificationService createNotificationService(final NotificationType notificationType) {
        if (notificationType == NotificationType.EMAIL) {
            return (NotificationService) applicationContext.getBean("emailNotificationService");
        }
        throw new IllegalArgumentException("Notification Type not implemented yet: " + notificationType);
    }
}
