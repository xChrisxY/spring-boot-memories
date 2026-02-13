package com.chris.project.memories.love.infrastructure.security.adapters;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.chris.project.memories.love.domain.ports.in.PasswordEncoderPort;

@Component
public class BCryptPasswordEncoderAdapter implements PasswordEncoderPort {

      private final PasswordEncoder passwordEncoder;

      public BCryptPasswordEncoderAdapter(PasswordEncoder passwordEncoder){
            this.passwordEncoder = passwordEncoder;
      }

      @Override
      public String encode(String rawPassword){
            return passwordEncoder.encode(rawPassword);
      }

}
