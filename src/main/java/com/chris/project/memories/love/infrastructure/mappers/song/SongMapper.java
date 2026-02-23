package com.chris.project.memories.love.infrastructure.mappers.song;

import org.mapstruct.Mapper;

import com.chris.project.memories.love.domain.models.Song;
import com.chris.project.memories.love.infrastructure.dto.song.SongDTO;
import com.chris.project.memories.love.infrastructure.dto.song.SongResponseDTO;

@Mapper(componentModel = "spring")
public interface SongMapper {

      Song toDomain(SongDTO dto);
      SongResponseDTO toResponseDTO(Song song);

}
