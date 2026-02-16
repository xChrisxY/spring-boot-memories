package com.chris.project.memories.love.infrastructure.security.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chris.project.memories.love.infrastructure.entities.UserEntity;
import com.chris.project.memories.love.infrastructure.repositories.JpaUserRepository;

@Service
public class JpaUserUserDetailsService implements UserDetailsService {

      private final JpaUserRepository userRepository;

      public JpaUserUserDetailsService(JpaUserRepository userRepository){
            this.userRepository = userRepository;
      }

      @Override
      @Transactional(readOnly = true)
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

            Optional<UserEntity> optionalUser;

            return null;
      }

      

}
