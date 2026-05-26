package com.bwartsmaker.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http

            // 🔥 ESSENCIAL: ativa CORS usando seu CorsConfig
            .cors(Customizer.withDefaults())

            // API REST não usa CSRF
            .csrf(csrf -> csrf.disable())

            // libera tudo (para API pública)
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()
            );

        return http.build();
    }
}