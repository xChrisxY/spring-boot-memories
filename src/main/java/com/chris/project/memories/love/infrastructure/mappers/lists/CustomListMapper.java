package com.chris.project.memories.love.infrastructure.mappers.lists;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.chris.project.memories.love.domain.models.CustomList;
import com.chris.project.memories.love.infrastructure.dto.lists.CustomListDTO;
import com.chris.project.memories.love.infrastructure.dto.lists.CustomListResponseDTO;

@Mapper(componentModel = "spring")
public interface CustomListMapper {

      CustomList toDomain(CustomListDTO dto);
      CustomListResponseDTO toResponseDTO(CustomList customList);
      
}
