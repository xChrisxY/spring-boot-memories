package com.chris.project.memories.love.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.chris.project.memories.love.infrastructure.entities.SongEntity;

public interface JpaSongRepository extends CrudRepository<SongEntity, UUID> {

}
