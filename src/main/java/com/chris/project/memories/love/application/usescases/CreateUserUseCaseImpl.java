package com.chris.project.memories.love.application.usescases;

import org.springframework.stereotype.Component;

import com.chris.project.memories.love.domain.models.User;
import com.chris.project.memories.love.domain.ports.in.CreateUserUseCase;
import com.chris.project.memories.love.domain.ports.in.PasswordEncoderPort;
import com.chris.project.memories.love.domain.ports.on.UserRepositoryPort;

@Component
public class CreateUserUseCaseImpl implements CreateUserUseCase {

      private final UserRepositoryPort userRepository;
      private final PasswordEncoderPort passwordEncoder;

      public CreateUserUseCaseImpl(UserRepositoryPort userRepository, PasswordEncoderPort passwordEncoder) {
            this.userRepository = userRepository;
            this.passwordEncoder = passwordEncoder;
      }

      @Override
      public User execute(User user){

            String passwordHash = passwordEncoder.encode(user.getPasswordHash());
            user.setPasswordHash(passwordHash);

            return userRepository.save(user);
      }

}
