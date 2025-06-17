package com.nrs.notifier.notification.service;

import com.nrs.notifier.dto.NotificationMessage;

public interface NotificationService {
    void send(NotificationMessage notificationMessage);
}
