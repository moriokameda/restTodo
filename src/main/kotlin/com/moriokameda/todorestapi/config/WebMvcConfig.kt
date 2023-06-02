package com.moriokameda.todorestapi.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class WebMvcConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.csrf {
            it.ignoringRequestMatchers("/todo","/todo/**")
        }
        http.authorizeHttpRequests {
            it.requestMatchers(HttpMethod.GET,"/todo","/todo/{id}").permitAll()
            it.requestMatchers(HttpMethod.POST,"/todo").permitAll()
            it.requestMatchers(HttpMethod.PUT,"/todo/{id}").permitAll()
            it.requestMatchers(HttpMethod.DELETE,"/todo/{id}").permitAll()
            it.anyRequest().authenticated()
        }
        return http.build()
    }
}