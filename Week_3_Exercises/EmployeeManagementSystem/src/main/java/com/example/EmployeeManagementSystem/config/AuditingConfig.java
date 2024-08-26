package com.example.employeemanagementsystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.config.EnableJpaAuditing;

@Configuration
@EnableJpaRepositories
@EnableJpaAuditing
public class AuditingConfig {
}
