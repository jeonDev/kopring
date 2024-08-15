package com.study.kopring.config

import org.springframework.boot.autoconfigure.security.servlet.PathRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .headers {it ->
                it.frameOptions { frameOptions ->
                    frameOptions.sameOrigin()
                }
            }
            .authorizeHttpRequests { auth ->
                auth
                    .requestMatchers(PathRequest.toH2Console()).permitAll()
                    .requestMatchers("/test/**").permitAll()
                    .requestMatchers("/board/**").permitAll()
                    .anyRequest().authenticated()
            }
        return http.build()
    }
}