package com.example.employeemanagementsystem.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        // Replace this with logic to retrieve the current user from the security context
        // For simplicity, returning a fixed username
        return Optional.of("system");
    }
}
