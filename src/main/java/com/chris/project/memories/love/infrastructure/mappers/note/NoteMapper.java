package com.chris.project.memories.love.infrastructure.mappers.note;

import java.util.List;

import org.mapstruct.Mapper;

import com.chris.project.memories.love.domain.models.Note;
import com.chris.project.memories.love.infrastructure.dto.note.NoteDTO;
import com.chris.project.memories.love.infrastructure.dto.note.NoteResponseDTO;

@Mapper(componentModel = "spring")
public interface NoteMapper {

      Note toDomain(NoteDTO dto);
      NoteResponseDTO toResponseDTO(Note note);
      List<NoteResponseDTO> toListResponseDTO(List<Note> notes);

}
