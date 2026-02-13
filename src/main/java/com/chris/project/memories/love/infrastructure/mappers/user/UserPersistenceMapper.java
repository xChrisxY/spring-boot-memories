package com.chris.project.memories.love.infrastructure.mappers.user;

import org.mapstruct.Mapper;

import com.chris.project.memories.love.domain.models.User;
import com.chris.project.memories.love.infrastructure.entities.UserEntity;

@Mapper(componentModel = "spring")
public interface UserPersistenceMapper {

      User toDomain(UserEntity entity);
      UserEntity toEntity(User user);
      
}
