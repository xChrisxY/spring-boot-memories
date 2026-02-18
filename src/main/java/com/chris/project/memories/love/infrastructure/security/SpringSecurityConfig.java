package com.chris.project.memories.love.infrastructure.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.chris.project.memories.love.infrastructure.security.filters.JwtAuthenticationFilter;
import com.chris.project.memories.love.infrastructure.security.filters.JwtValidationFilter;

@Configuration
public class SpringSecurityConfig {

      @Autowired
      private AuthenticationConfiguration authenticationConfiguration;

      @Bean
      PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
      }

      @Bean
      SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{

            AuthenticationManager authenticationManager = authenticationConfiguration.getAuthenticationManager();

            JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager);
            JwtValidationFilter jwtValidationFilter = new JwtValidationFilter(authenticationManager);
            jwtAuthenticationFilter.setFilterProcessesUrl("/api/auth/login");

            return httpSecurity.authorizeHttpRequests((authorize) -> authorize
                  
                  .requestMatchers(HttpMethod.POST, "/api/users/register").permitAll()
                  //.requestMatchers(HttpMethod.POST, "/api/memories")
                  .anyRequest().authenticated())
                  .addFilter(jwtAuthenticationFilter)
                  .addFilter(jwtValidationFilter)
                  .csrf(AbstractHttpConfigurer::disable)
                  .sessionManagement(managment -> managment.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                  .build();

      }
}
