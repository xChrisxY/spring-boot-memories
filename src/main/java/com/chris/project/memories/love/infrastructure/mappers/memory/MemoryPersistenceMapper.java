package com.chris.project.memories.love.infrastructure.mappers.memory;

import org.mapstruct.Mapper;

import com.chris.project.memories.love.domain.models.Memory;
import com.chris.project.memories.love.infrastructure.entities.MemoryEntity;

@Mapper(componentModel = "spring")
public interface MemoryPersistenceMapper {

      MemoryEntity toEntity(Memory memory);
      Memory toDomain(MemoryEntity entity);

}
