package com.chris.project.memories.love.infrastructure.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.chris.project.memories.love.infrastructure.entities.UserEntity;

public interface JpaUserRepository extends CrudRepository<UserEntity, UUID>{

      Optional<UserEntity> findByUsername(String username);
}
