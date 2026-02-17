package com.chris.project.memories.love.infrastructure.mappers.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.chris.project.memories.love.domain.models.User;
import com.chris.project.memories.love.infrastructure.entities.UserEntity;

@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {

      User toDomain(UserEntity entity);

      @Mapping(target = "roles", ignore = true)
      UserEntity toEntity(User user);
      
}
