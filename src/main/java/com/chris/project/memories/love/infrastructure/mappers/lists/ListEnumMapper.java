package com.chris.project.memories.love.infrastructure.mappers.lists;

import java.util.List;

import org.mapstruct.Mapper;

import com.chris.project.memories.love.domain.models.ListEnum;
import com.chris.project.memories.love.infrastructure.dto.lists.ListEnumDTO;
import com.chris.project.memories.love.infrastructure.dto.lists.ListEnumResponseDTO;

@Mapper(componentModel = "spring")
public interface ListEnumMapper {

      ListEnum toDomain(ListEnumDTO dto);
      ListEnumResponseDTO toResponseDTO(ListEnum listEnum);
      List<ListEnumResponseDTO> toListResponseDTO(List<ListEnum> listEnums);

}
