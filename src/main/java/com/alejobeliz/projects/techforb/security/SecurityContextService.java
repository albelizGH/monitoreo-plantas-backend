package com.alejobeliz.projects.techforb.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityContextService {

    public Long getIdDeUsuarioDesdeAuthenticated() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new IllegalStateException("Usuario no autenticado");
        }
        ClientUserDetail userDetails = (ClientUserDetail) authentication.getPrincipal();
        return userDetails.getClienteId();

    }
}
