package com.chris.project.memories.love.infrastructure.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.chris.project.memories.love.infrastructure.entities.MemoryEntity;

public interface JpaMemoryRepository extends CrudRepository<MemoryEntity, UUID> {

      List<MemoryEntity> findAll();
}
