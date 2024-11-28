package com.metacoding.authblog._core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.csrf(c -> c.disable());

        http.authorizeHttpRequests(r ->
                r.requestMatchers("/s/**").authenticated().anyRequest().permitAll())
                .formLogin(f ->
                        f.loginPage("/login-form")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/"));

        return http.build();
    }

    // 평문 hash로 바꿔준다.
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
