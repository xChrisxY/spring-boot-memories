package com.chris.project.memories.love.infrastructure.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.chris.project.memories.love.infrastructure.entities.RoleEntity;

public interface JpaRoleRepository extends CrudRepository<RoleEntity, UUID> {
      Optional<RoleEntity> findByName(String name);     
}
