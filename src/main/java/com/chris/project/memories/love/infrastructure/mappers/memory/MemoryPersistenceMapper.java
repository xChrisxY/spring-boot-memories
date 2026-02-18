package com.chris.project.memories.love.infrastructure.mappers.memory;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.chris.project.memories.love.domain.models.Memory;
import com.chris.project.memories.love.infrastructure.entities.MemoryEntity;

@Mapper(componentModel = "spring")
public interface MemoryPersistenceMapper {

      //@Mapping(target = "entityUser", ignore = true)
      MemoryEntity toEntity(Memory memory);
      Memory toDomain(MemoryEntity entity);

}
