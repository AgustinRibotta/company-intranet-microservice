package com.company.intranet.auth_service.exeptions;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class ErrorDetails extends RuntimeException {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;
    private String details;

    public ErrorDetails(LocalDateTime timestamp, String message, String details) {
        super(message);
        this.timestamp = timestamp;
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getDetails() {
        return details;
    }
}
