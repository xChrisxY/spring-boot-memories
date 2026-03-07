package com.chris.project.memories.love.infrastructure.mappers.song;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.chris.project.memories.love.domain.models.Song;
import com.chris.project.memories.love.infrastructure.dto.song.SongDTO;
import com.chris.project.memories.love.infrastructure.dto.song.SongResponseDTO;

@Mapper(componentModel = "spring")
public interface SongMapper {

      @Mapping(target = "id", ignore = true)
      @Mapping(target = "createdAt", ignore = true)
      @Mapping(target = "user", ignore = true)
      Song toDomain(SongDTO dto);
      
      SongResponseDTO toResponseDTO(Song song);
      List<SongResponseDTO> toListResponseDTO(List<Song> songs);

}
