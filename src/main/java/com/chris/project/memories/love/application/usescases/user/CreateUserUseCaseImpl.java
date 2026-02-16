package com.chris.project.memories.love.application.usescases.user;

import org.springframework.stereotype.Component;

import com.chris.project.memories.love.domain.models.User;
import com.chris.project.memories.love.domain.ports.in.user.CreateUserUseCase;
import com.chris.project.memories.love.domain.ports.in.user.PasswordEncoderPort;
import com.chris.project.memories.love.domain.ports.on.user.UserRepositoryPort;

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
