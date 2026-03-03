package com.chris.project.memories.love.infrastructure.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.chris.project.memories.love.infrastructure.entities.ListEnumEntity;

public interface JpaListEnumRepository extends CrudRepository<ListEnumEntity, UUID> {

      List<ListEnumEntity> findByListId(UUID listId);
}
