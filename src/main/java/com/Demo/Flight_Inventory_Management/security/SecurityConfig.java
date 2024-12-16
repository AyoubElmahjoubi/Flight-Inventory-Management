package com.Demo.Flight_Inventory_Management.security;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    private final JwtFilter jwtAuthFilter ;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, CacheManagerCustomizers cacheManagerCustomizers) throws Exception {
        http
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req.requestMatchers(
                                "/auth/**",
                                "/v2/api-docs/",
                                "/v3/api-docs/",
                                "/v3/api-docs/**",
                                "/swagger-ressources/",
                                "/swagger-ressources/**",
                                "/configuration/ui",
                                "/configuration/security",
                                "/swagger-ui/**",
                                "/webjars/**",
                                "swagger-ui.html"

                        ).permitAll()
                                .requestMatchers(
                                        "api/v1/admin/register-admin",
                                        "api/v1/airplane/**",
                                        "api/v1/airport/**",
                                        "api/v1/flights/add-Flight",
                                        "api/v1/flights/delete/**",
                                        "api/v1/flights/all-flights"
                                ).hasAuthority("ADMIN")
                                .anyRequest()
                                    .authenticated()

                )
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter , UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }




}


