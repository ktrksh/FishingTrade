package com.fishingtrade.fishing_info_share.config;

import com.fishingtrade.fishing_info_share.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    private HandlerMappingIntrospector introspector;

    @Autowired
    public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        MvcRequestMatcher h2ConsoleMatcher = new MvcRequestMatcher(introspector, "/h2-console/**");
        http.authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(h2ConsoleMatcher).permitAll()
                        .requestMatchers("/users/register", "/catches/register").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/users/login")
                        .permitAll()
                )
                .logout(logout -> logout
                        .permitAll())
                .csrf(csrf -> csrf.ignoringRequestMatchers(h2ConsoleMatcher))
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));

        http.authenticationProvider(authenticationProvider());
        return http.build();
    }
}