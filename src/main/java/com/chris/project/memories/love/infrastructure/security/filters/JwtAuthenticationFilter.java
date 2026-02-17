package com.chris.project.memories.love.infrastructure.security.filters;

import static com.chris.project.memories.love.infrastructure.security.TokenJwtConfig.CONTENT_TYPE;
import static com.chris.project.memories.love.infrastructure.security.TokenJwtConfig.HEADER_AUTHORIZATION;
import static com.chris.project.memories.love.infrastructure.security.TokenJwtConfig.PREFIX_TOKEN;
import static com.chris.project.memories.love.infrastructure.security.TokenJwtConfig.SECRET_KEY;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.chris.project.memories.love.infrastructure.dto.user.LoginRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

      private final AuthenticationManager authenticationManager;

      public JwtAuthenticationFilter(AuthenticationManager authenticationManager){
            this.authenticationManager = authenticationManager;
      }

      @Override
      public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

            LoginRequestDTO login = null;
            String username = null;
            String password = null;
                  
            try {
                  login = new ObjectMapper().readValue(request.getInputStream(), LoginRequestDTO.class);
                  username = login.getUsername();
                  password = login.getPassword();
            } catch (Exception e) {
                  e.printStackTrace();
            }

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                  username, password
            );

            return authenticationManager.authenticate(authenticationToken);
            
      }

      @Override
      protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                  FilterChain chain, Authentication authResult) throws IOException, ServletException {

            User user = (User) authResult.getPrincipal();
            String username = user.getUsername();

            Collection<? extends GrantedAuthority> roles = authResult.getAuthorities();
            List<String> authorities = roles.stream()
                        .map(GrantedAuthority::getAuthority)
                        .toList();

            Claims claims = Jwts.claims().add("authorities", authorities).build();

            String token = Jwts.builder() 
                        .subject(username)
                        .claims(claims)
                        .signWith(SECRET_KEY)
                        .issuedAt(new Date())
                        .expiration(new Date(System.currentTimeMillis() + 36000000))
                        .compact();

            Map<String, String> body = new HashMap<>();
            body.put("token", token);
            body.put("message", String.format("%s has iniciado sesión con éxito", username));

            response.getWriter().write(new ObjectMapper().writeValueAsString(body));
            response.addHeader(HEADER_AUTHORIZATION, PREFIX_TOKEN + token);
            response.setContentType(CONTENT_TYPE);
            response.setStatus(200);
      }

      @Override
      protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                  AuthenticationException failed) throws IOException, ServletException {

            Map<String, String> body = new HashMap<>();

            body.put("message", "Error en la autenticación, username or password incorrectos.");
            body.put("error", failed.getMessage());

            response.getWriter().write(new ObjectMapper().writeValueAsString(body));
            response.setContentType(CONTENT_TYPE);
            response.setStatus(401);
      }

}
