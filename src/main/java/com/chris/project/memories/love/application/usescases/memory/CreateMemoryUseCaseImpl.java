package com.chris.project.memories.love.application.usescases.memory;

import org.springframework.stereotype.Component;

import com.chris.project.memories.love.domain.models.Memory;
import com.chris.project.memories.love.domain.ports.in.memory.CreateMemoryUseCase;
import com.chris.project.memories.love.domain.ports.on.memory.MemoryRepositoryPort;

@Component
public class CreateMemoryUseCaseImpl implements CreateMemoryUseCase {

      private final MemoryRepositoryPort memoryRepository;

      public CreateMemoryUseCaseImpl(MemoryRepositoryPort memoryRepository) {
            this.memoryRepository = memoryRepository;
      }

      @Override
      public Memory execute(Memory memory){
            return memoryRepository.save(memory);
      }
}
