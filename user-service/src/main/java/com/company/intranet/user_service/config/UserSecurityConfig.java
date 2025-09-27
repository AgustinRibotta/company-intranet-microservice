package com.company.intranet.user_service.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserSecurityConfig {

    @Transactional
    public boolean isUser(Long requestedId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            return false;
        }

        Long userIdFromToken = ((JwtAuthenticationToken) authentication)
                                .getToken()
                                .getClaim("userId");

        return requestedId.equals(userIdFromToken);
    }
}
