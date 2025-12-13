package com.company.intranet.user_service.exeptions;

public class ExternalServiceException extends RuntimeException{

    public ExternalServiceException(String message) {
        super(message);
    }

    public ExternalServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
