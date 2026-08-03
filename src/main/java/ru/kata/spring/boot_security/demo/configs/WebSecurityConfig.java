package ru.kata.spring.boot_security.demo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import ru.kata.spring.boot_security.demo.configs.LoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {


    private final LoginSuccessHandler successHandler;


    public WebSecurityConfig(LoginSuccessHandler successHandler){
        this.successHandler = successHandler;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        http
                .authorizeRequests(auth -> auth

                        .antMatchers("/admin/**")
                        .hasRole("ADMIN")

                        .antMatchers("/user")
                        .hasAnyRole("USER", "ADMIN")

                        .anyRequest().authenticated()
                )


                .formLogin(login -> login
                        .successHandler(successHandler)
                )


                .logout(logout -> logout
                        .logoutSuccessUrl("/login")
                );


        return http.build();
    }
}