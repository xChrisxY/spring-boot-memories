package com.chris.project.memories.love.infrastructure.mappers.lists;

import org.mapstruct.Mapper;

import com.chris.project.memories.love.domain.models.ListEnum;
import com.chris.project.memories.love.infrastructure.entities.ListEnumEntity;

@Mapper(componentModel = "spring")
public interface ListEnumPersistenceMapper {

      ListEnum toDomain(ListEnumEntity entity);
      ListEnumEntity toEntity(ListEnum listEnum);
}
