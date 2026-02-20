package com.chris.project.memories.love.infrastructure.repositories.adapters;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chris.project.memories.love.domain.models.Memory;
import com.chris.project.memories.love.domain.ports.on.memory.MemoryRepositoryPort;
import com.chris.project.memories.love.infrastructure.entities.MemoryEntity;
import com.chris.project.memories.love.infrastructure.mappers.memory.MemoryPersistenceMapper;
import com.chris.project.memories.love.infrastructure.repositories.JpaMemoryRepository;

@Repository
public class JpaMemoryRepositoryAdapter implements MemoryRepositoryPort {

      private final JpaMemoryRepository memoryRepository;
      private final MemoryPersistenceMapper memoryMapper;

      public JpaMemoryRepositoryAdapter(JpaMemoryRepository memoryRepository, MemoryPersistenceMapper memoryMapper){
            this.memoryRepository = memoryRepository;
            this.memoryMapper = memoryMapper;
      }

      @Override
      @Transactional
      public Memory save(Memory memory){
            MemoryEntity entity = memoryMapper.toEntity(memory);
            MemoryEntity newEntity = memoryRepository.save(entity);
            return memoryMapper.toDomain(newEntity);
      }

      @Override
      @Transactional(readOnly = true)
      public Optional<Memory> findByUUID(UUID uuid){
            return memoryRepository.findById(uuid)
                  .map(memory -> memoryMapper.toDomain(memory));
      }

      @Override
      @Transactional(readOnly = true)
      public List<Memory> findAll(){
            return memoryRepository.findAll().stream()
                  .map(memory -> memoryMapper.toDomain(memory))
                  .collect(Collectors.toList());
      }
}
