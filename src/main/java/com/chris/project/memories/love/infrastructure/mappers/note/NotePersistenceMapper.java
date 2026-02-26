package com.chris.project.memories.love.infrastructure.mappers.note;

import org.mapstruct.Mapper;

import com.chris.project.memories.love.domain.models.Note;
import com.chris.project.memories.love.infrastructure.entities.NoteEntity;

@Mapper(componentModel = "spring")
public interface NotePersistenceMapper {

      Note toDomain(NoteEntity entity);
      NoteEntity toEntity(Note note);

}
