package com.example.authentication_service.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Configuration
@EnableWebFluxSecurity
public class WebSecurityConfig {
    private final JwtAuthConverter jwtAuthConverter;

    public static final String ADMIN = "admin";
    public static final String ADMIN_ACCOMMODATION = "admin-accommodation";
    public static final String CLIENT_USER = "client-user";


    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) {
        http.authorizeExchange(e ->
                e.pathMatchers("/**").permitAll()
                        .anyExchange().authenticated());

        http.oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter((Converter<Jwt, ? extends Mono<? extends AbstractAuthenticationToken>>) jwtAuthConverter);
        http.csrf().disable();
        return http.build();
    }
}
