package com.company.intranet.user_service.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class SecurityConfigUser {

    @Transactional
    public boolean isUser(UUID requestedId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return false;
        }

        String userIdStr = ((JwtAuthenticationToken) authentication)
                .getToken()
                .getClaim("userId");

        UUID userIdFromToken = UUID.fromString(userIdStr);

        return requestedId.equals(userIdFromToken);
    }
}
