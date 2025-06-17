package com.nrs.notifier.notification.service.enm;

import java.util.Arrays;

public enum NotificationType {
    EMAIL(0, "Email"),
    MESSAGE(1, "SMS message"),
    WHATSAPP(2, "Whatsapp message");

    private int id;
    private String description;

    NotificationType(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public static NotificationType fromString(final String notificationType) {
        return Arrays.stream(NotificationType.values())
                .filter(t -> t == NotificationType.valueOf(notificationType))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Notification Type not implemented yet: " + notificationType));

    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
