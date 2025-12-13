package com.company.intranet.user_service.dtos.request;

import java.util.UUID;

public class RhRequest {

    private UUID userId;
    private String email;
    private String firstName;

    public RhRequest() {
    }

    public RhRequest(UUID userId, String email, String firstName) {
        this.userId = userId;
        this.email = email;
        this.firstName = firstName;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
