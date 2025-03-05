package com.laye.blog.blogapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) // Désactiver CSRF (à activer en production !)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/users/**").permitAll() // Autoriser toutes les requêtes vers /api/users
                        .anyRequest().authenticated()
                )
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("admin")
                .password("{noop}admin") // {noop} signifie pas de hash pour le mot de passe (temporaire)
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}
