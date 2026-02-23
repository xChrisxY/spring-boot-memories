package com.chris.project.memories.love.infrastructure.mappers.song;

import org.mapstruct.Mapper;

import com.chris.project.memories.love.domain.models.Song;
import com.chris.project.memories.love.infrastructure.entities.SongEntity;

@Mapper(componentModel = "spring")
public interface SongPersistenceMapper {

      Song toDomain(SongEntity entity);
      SongEntity toEntity(Song song);
}
