package com.db.hackathon.credit_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
          // Disable CSRF for APIs and H2 console
          .csrf(csrf -> csrf
            .ignoringRequestMatchers("/**/**", "/api/**")
            .disable()
          )
          // Allow frames for H2 console
          .headers(headers -> headers
            .frameOptions(frame -> frame.disable())
          )
          // Permit all access to API endpoints and H2 console
          .authorizeHttpRequests(auth -> auth
            .requestMatchers("/api/**").permitAll()
            .requestMatchers("/h2-console/**").permitAll()
            .anyRequest().permitAll()
          )
          // Optional: HTTP Basic for convenience (can remove if not needed)
          .httpBasic();

        return http.build();
    }
}
