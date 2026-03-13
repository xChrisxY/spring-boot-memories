package com.chris.project.memories.love.infrastructure.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.chris.project.memories.love.infrastructure.entities.CustomListEntity;

public interface JpaCustomListRepository extends CrudRepository<CustomListEntity, UUID> {

      List<CustomListEntity> findAll();

}
