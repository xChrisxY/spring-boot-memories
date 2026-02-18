package com.chris.project.memories.love.application.usescases.memory;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.chris.project.memories.love.domain.exceptions.UserNotFoundException;
import com.chris.project.memories.love.domain.models.ImageUploadResult;
import com.chris.project.memories.love.domain.models.Memory;
import com.chris.project.memories.love.domain.models.User;
import com.chris.project.memories.love.domain.ports.in.memory.CreateMemoryUseCase;
import com.chris.project.memories.love.domain.ports.on.memory.ImageStoragePort;
import com.chris.project.memories.love.domain.ports.on.memory.MemoryRepositoryPort;
import com.chris.project.memories.love.domain.ports.on.user.UserRepositoryPort;

@Component
public class CreateMemoryUseCaseImpl implements CreateMemoryUseCase {

      private final MemoryRepositoryPort memoryRepository;
      private final UserRepositoryPort userRepository;
      private final ImageStoragePort imageStorage;

      public CreateMemoryUseCaseImpl(
            MemoryRepositoryPort memoryRepository, 
            UserRepositoryPort userRepository, 
            ImageStoragePort imageStorage
      ) {
            this.memoryRepository = memoryRepository;
            this.userRepository = userRepository;
            this.imageStorage = imageStorage;
      }

      @Override
      public Memory execute(Memory memory, String userCreator, byte[] imageContent, String filename){

            ImageUploadResult result = imageStorage.upload(imageContent, filename);
            memory.setImageUrl(result.getUrl());

            User user = userRepository.findByUsername(userCreator)
                  .orElseThrow(() -> new UserNotFoundException("El usuario no fue encontrado: " + userCreator));

            memory.setUser(user);

            return memoryRepository.save(memory);
      }
}
