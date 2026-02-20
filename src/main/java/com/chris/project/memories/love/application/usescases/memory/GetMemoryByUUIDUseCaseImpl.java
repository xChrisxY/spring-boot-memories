package com.chris.project.memories.love.application.usescases.memory;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.chris.project.memories.love.domain.exceptions.MemoryNotFoundException;
import com.chris.project.memories.love.domain.models.Memory;
import com.chris.project.memories.love.domain.ports.in.memory.GetMemoryByUUIDUseCase;
import com.chris.project.memories.love.domain.ports.on.memory.MemoryRepositoryPort;

@Component
public class GetMemoryByUUIDUseCaseImpl implements GetMemoryByUUIDUseCase {

      private final MemoryRepositoryPort memoryRepository;

      public GetMemoryByUUIDUseCaseImpl(MemoryRepositoryPort memoryRepository){
            this.memoryRepository = memoryRepository;
      }

      @Override
      public Memory execute(UUID uuid){
            return memoryRepository.findByUUID(uuid)
                  .orElseThrow(() -> new MemoryNotFoundException("Memory not found: " + uuid));
      }


}
