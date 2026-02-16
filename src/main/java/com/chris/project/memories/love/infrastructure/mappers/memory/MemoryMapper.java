package com.chris.project.memories.love.infrastructure.mappers.memory;

import org.mapstruct.Mapper;

import com.chris.project.memories.love.domain.models.Memory;
import com.chris.project.memories.love.infrastructure.dto.memory.MemoryDTO;
import com.chris.project.memories.love.infrastructure.dto.memory.MemoryResponseDTO;

@Mapper(componentModel = "spring")
public interface MemoryMapper {

      Memory toDomain(MemoryDTO dto);
      MemoryResponseDTO toResponseDTO(Memory memory);

}
