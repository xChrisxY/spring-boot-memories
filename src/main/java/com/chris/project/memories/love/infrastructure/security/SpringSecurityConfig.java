package com.chris.project.memories.love.infrastructure.security;

import java.util.List;

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
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

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
      CorsConfigurationSource corsConfigurationSource() {

            CorsConfiguration configuration = new CorsConfiguration();

            configuration.setAllowedOriginPatterns(List.of("*"));
            configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));
            configuration.setAllowedHeaders(List.of("*"));
            configuration.setAllowCredentials(true);

            configuration.setExposedHeaders(List.of("Authorization"));
             
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", configuration);

            return source;
      }

      private static final String[] WHITE_LIST_URLS = {
            "/api/swagger-ui/**",
            "/api/swagger-ui.html",
            "/api/v3/api-docs/**",
            "/api/v3/api-docs.yaml",
            "/api/api-docs/**",
            "/api/swagger-resources/**",
            "/api/webjars/**"
      };

      @Bean
      SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{

            AuthenticationManager authenticationManager = authenticationConfiguration.getAuthenticationManager();

            JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager);
            JwtValidationFilter jwtValidationFilter = new JwtValidationFilter(authenticationManager);
            jwtAuthenticationFilter.setFilterProcessesUrl("/api/auth/login");

            return httpSecurity

                  .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                  .csrf(AbstractHttpConfigurer::disable)
                  .sessionManagement(managment -> managment.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                  .authorizeHttpRequests(authorize -> authorize
                  .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll() 
                  .requestMatchers("/api/auth/login").permitAll()
                  .requestMatchers("/api/users/register").permitAll()
                  .requestMatchers(WHITE_LIST_URLS).permitAll()
                  //.requestMatchers(HttpMethod.POST, "/api/memories")
                  .anyRequest().authenticated())

                  .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                  .addFilterAfter(jwtValidationFilter, UsernamePasswordAuthenticationFilter.class)
                  .build();

      }
}
