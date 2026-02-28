package com.chris.project.memories.love.infrastructure.mappers.lists;

import org.mapstruct.Mapper;

import com.chris.project.memories.love.domain.models.CustomList;
import com.chris.project.memories.love.infrastructure.entities.CustomListEntity;

@Mapper(componentModel = "spring")
public interface CustomListPersistenceMapper {

      CustomListEntity toEntity(CustomList customList);
      CustomList toDomain(CustomListEntity entity);
}
