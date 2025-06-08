package com.nrs.notifier.dto;

public class NotificationsResponseDto {
    private boolean success;
    private String responseMessage;

    public NotificationsResponseDto(boolean success, String responseMessage) {
        this.success = success;
        this.responseMessage = responseMessage;
    }
}
