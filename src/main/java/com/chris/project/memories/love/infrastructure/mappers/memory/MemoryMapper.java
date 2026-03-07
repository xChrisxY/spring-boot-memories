package com.chris.project.memories.love.infrastructure.mappers.memory;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.chris.project.memories.love.domain.models.Memory;
import com.chris.project.memories.love.infrastructure.dto.memory.MemoryDTO;
import com.chris.project.memories.love.infrastructure.dto.memory.MemoryResponseDTO;

@Mapper(componentModel = "spring")
public interface MemoryMapper {

      @Mapping(target = "id", ignore = true)
      @Mapping(target = "imageUrl", ignore = true)
      @Mapping(target = "createdAt", ignore = true)
      @Mapping(target = "user", ignore = true)
      Memory toDomain(MemoryDTO dto);
      
      MemoryResponseDTO toResponseDTO(Memory memory);
      List<MemoryResponseDTO> toResponseDTOToList(List<Memory> memories);

}
