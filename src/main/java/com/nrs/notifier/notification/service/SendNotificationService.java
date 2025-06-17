package com.nrs.notifier.notification.service;

import com.nrs.notifier.dto.NotificationMessage;

public interface SendNotificationService {
    void send(NotificationMessage notificationMessage);
}
