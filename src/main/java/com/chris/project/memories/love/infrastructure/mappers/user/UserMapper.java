package com.chris.project.memories.love.infrastructure.mappers.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.chris.project.memories.love.domain.models.User;
import com.chris.project.memories.love.infrastructure.dto.user.UserDTO;
import com.chris.project.memories.love.infrastructure.dto.user.UserResponseDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {

      @Mapping(source = "password", target = "passwordHash")
      User toDomain(UserDTO dto);
      UserResponseDTO toResponseDTO(User user);
}
