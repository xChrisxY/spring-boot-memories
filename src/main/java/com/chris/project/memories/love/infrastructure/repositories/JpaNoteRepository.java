package com.chris.project.memories.love.infrastructure.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.chris.project.memories.love.infrastructure.entities.NoteEntity;

public interface JpaNoteRepository extends CrudRepository<NoteEntity, UUID> {

      List<NoteEntity> findAll();
}
