package com.example.board.config;

import com.example.board.service.UsersDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final UsersDetailService usersDetailService;

    public SecurityConfig(UsersDetailService usersDetailService) {
        this.usersDetailService = usersDetailService;
    }


    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    protected void configuration(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usersDetailService);
    }
    @Bean
    public SecurityFilterChain configuration(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(AbstractHttpConfigurer::disable)
                .formLogin(form->form
                        .usernameParameter("email")


                        .defaultSuccessUrl("/board/user/home"))
                .authorizeHttpRequests(req->req.anyRequest().permitAll())
                .build();
    }
}
