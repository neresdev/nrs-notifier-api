package com.nrs.notifier.dto;

import java.io.Serializable;

public class NotificationResponseDto implements Serializable {
    private boolean success;
    private String responseMessage;

    public NotificationResponseDto(boolean success, String responseMessage) {
        this.success = success;
        this.responseMessage = responseMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
