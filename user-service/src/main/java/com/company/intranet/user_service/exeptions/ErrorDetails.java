package com.company.intranet.user_service.exeptions;

import java.time.LocalDateTime;

public class ErrorDetails {

    private LocalDateTime timestamp;
    private String massege;
    private String details;
    
    public ErrorDetails(LocalDateTime timestamp, String massege, String details) {
        this.timestamp = timestamp;
        this.massege = massege;
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMassege() {
        return massege;
    }
  
    public void setMassege(String massege) {
        this.massege = massege;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}