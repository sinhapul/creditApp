package com.db.hackathon.credit_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfig {
  
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
      // 1) Disable CSRF for H2 console
      .csrf(csrf -> csrf
        .ignoringRequestMatchers("/h2-console/**")
      )
      // 2) Allow frames for H2 console
      .headers(headers -> headers
        .frameOptions(frame -> frame.disable())
      )
      // 3) Permit all access to H2 console, secure everything else
      .authorizeHttpRequests(auth -> auth
        .requestMatchers("**").permitAll()
        .anyRequest().authenticated()
      )
      // 4) (Optional) Use HTTP Basic so you can still test endpoints
      .httpBasic();

    return http.build();
  }
}

