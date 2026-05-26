package com.bwartsmaker.backend.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration config = new CorsConfiguration();

        // =========================
        // ORIGENS PERMITIDAS
        // =========================
        config.setAllowedOriginPatterns(List.of("*"));
        // Em produção: substitua por domínio real
        // ex: https://meusite.com

        // =========================
        // MÉTODOS HTTP
        // =========================
        config.setAllowedMethods(List.of(
                "GET",
                "POST",
                "PUT",
                "DELETE",
                "OPTIONS",
                "PATCH"
        ));

        // =========================
        // HEADERS
        // =========================
        config.setAllowedHeaders(List.of("*"));

        // =========================
        // CREDENCIAIS (cookies, auth)
        // =========================
        config.setAllowCredentials(false);

        // =========================
        // CACHE DO PRE-FLIGHT
        // =========================
        config.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();

        source.registerCorsConfiguration("/**", config);

        return source;
    }
}