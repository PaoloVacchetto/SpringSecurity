package com.example.springsec.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager


@Configuration
class SecurityConfiguration {
    @Bean
    fun userDetails( passwordEncoder: PasswordEncoder) : UserDetailsService {
        val u1 = User
            .withUsername("u1")
            .password(passwordEncoder.encode("p1"))
            .authorities("ROLE_CUSTOMER")
            .build()
        val u2 = User
            .withUsername("u2")
            .password(passwordEncoder.encode("p2"))
            .authorities("ROLE_CUSTOMER", "ROLE_ADMIN")
            .build()

        return InMemoryUserDetailsManager(u1, u2)
    }
    @Bean
    fun passwordEncoder() : PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()
}