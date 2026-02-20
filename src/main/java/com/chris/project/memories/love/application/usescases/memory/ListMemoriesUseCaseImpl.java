package com.chris.project.memories.love.application.usescases.memory;

import java.util.List;

import org.springframework.stereotype.Component;

import com.chris.project.memories.love.domain.models.Memory;
import com.chris.project.memories.love.domain.ports.in.memory.ListMemoriesUseCase;
import com.chris.project.memories.love.domain.ports.on.memory.MemoryRepositoryPort;

@Component
public class ListMemoriesUseCaseImpl implements ListMemoriesUseCase {

      private final MemoryRepositoryPort memoryRepository;

      public ListMemoriesUseCaseImpl(MemoryRepositoryPort memoryRepository){
            this.memoryRepository = memoryRepository;
      }

      @Override
      public List<Memory> execute(){
            return memoryRepository.findAll();
      }
}
