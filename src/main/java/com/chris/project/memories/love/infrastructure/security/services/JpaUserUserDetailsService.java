package com.chris.project.memories.love.infrastructure.security.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chris.project.memories.love.domain.exceptions.UserNotFoundException;
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

            Optional<UserEntity> optionalUser = userRepository.findByUsername(username);

            if (optionalUser.isEmpty()){
                  throw new UserNotFoundException(
                        String.format("El username % no existe en el sistema", username)
                  );
            }

            UserEntity user = optionalUser.get();

            List<GrantedAuthority> authorities = user.getRoles().stream()
                  .map(role -> new SimpleGrantedAuthority(role.getName()))
                  .collect(Collectors.toList());

            return new User(
                  user.getUsername(), 
                  user.getPasswordHash(), 
                  true,
                  true,
                  true,
                  false, authorities
            );

      }

}
