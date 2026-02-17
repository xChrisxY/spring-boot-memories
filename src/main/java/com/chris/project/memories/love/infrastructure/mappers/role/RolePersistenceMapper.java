package com.chris.project.memories.love.infrastructure.mappers.role;

import org.mapstruct.Mapper;

import com.chris.project.memories.love.domain.models.Role;
import com.chris.project.memories.love.infrastructure.entities.RoleEntity;

@Mapper(componentModel = "spring")
public interface RolePersistenceMapper {

      RoleEntity toEntity(Role role);
      Role toDomain(RoleEntity entity);
}
