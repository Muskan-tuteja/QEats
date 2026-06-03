//package com.jsp;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class Config {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
//
//        // Disable CSRF and allow all requests (JWT authentication removed)
//        security
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(http -> http
//                        .requestMatchers("/test/**").permitAll()
//                        .anyRequest().permitAll()
//                );
//
//        System.out.println("Security configured: JWT authentication removed, all endpoints permitted");
//
//        return security.build();
//    }
//}
