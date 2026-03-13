package com.chris.project.memories.love.infrastructure.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.project.memories.love.domain.models.Note;
import com.chris.project.memories.love.domain.ports.in.note.CreateNoteUseCase;
import com.chris.project.memories.love.domain.ports.in.note.GetNoteByUUIDUseCase;
import com.chris.project.memories.love.domain.ports.in.note.ListNotesUseCase;
import com.chris.project.memories.love.infrastructure.dto.ApiResponse;
import com.chris.project.memories.love.infrastructure.dto.note.NoteDTO;
import com.chris.project.memories.love.infrastructure.dto.note.NoteResponseDTO;
import com.chris.project.memories.love.infrastructure.mappers.note.NoteMapper;
import com.chris.project.memories.love.infrastructure.security.utils.SecurityUtils;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

      private final CreateNoteUseCase createNoteUseCase;
      private final GetNoteByUUIDUseCase getNoteByUUIDUseCase;
      private final ListNotesUseCase listNotesUseCase;
      private final NoteMapper noteMapper;

      public NoteController(
            CreateNoteUseCase createNoteUseCase, 
            GetNoteByUUIDUseCase getNoteByUUIDUseCase,
            ListNotesUseCase listNotesUseCase,
            NoteMapper noteMapper
      ){
            this.createNoteUseCase = createNoteUseCase;
            this.getNoteByUUIDUseCase = getNoteByUUIDUseCase;
            this.listNotesUseCase = listNotesUseCase;
            this.noteMapper = noteMapper;
      }

      @PostMapping
      public ResponseEntity<ApiResponse<NoteResponseDTO>> create(@Valid @RequestBody NoteDTO dto){

            Note note = noteMapper.toDomain(dto);
            String username = SecurityUtils.getCurrentUsername();
            Note newNote = createNoteUseCase.execute(note, username);

            NoteResponseDTO noteResponseDTO = noteMapper.toResponseDTO(newNote);
            ApiResponse<NoteResponseDTO> response = new ApiResponse<NoteResponseDTO>(
                  true, 
                  "Nota creada correctamente", 
                  201, 
                  noteResponseDTO
            );

            return ResponseEntity.status(HttpStatus.CREATED.value()).body(response);
      }

      @GetMapping("/{uuid}")
      public ResponseEntity<ApiResponse<NoteResponseDTO>> findByUUID(@PathVariable UUID uuid){

            Note note = getNoteByUUIDUseCase.execute(uuid);
            NoteResponseDTO noteResponseDTO = noteMapper.toResponseDTO(note);

            ApiResponse<NoteResponseDTO> response = new ApiResponse<NoteResponseDTO>(
                  true, 
                  "Notas obtenidas éxitosamente", 
                  200, 
                  noteResponseDTO
            );

            return ResponseEntity.status(HttpStatus.OK.value()).body(response);
      }

      @GetMapping
      public ResponseEntity<ApiResponse<List<NoteResponseDTO>>> findAll(){

            List<Note> notes = listNotesUseCase.execute();
            List<NoteResponseDTO> listNotesResponseDTO = noteMapper.toListResponseDTO(notes);

            ApiResponse<List<NoteResponseDTO>> response = new ApiResponse<List<NoteResponseDTO>>(
                  true, 
                  "Notas obtenidas satisfactoriamente", 
                  200, 
                  listNotesResponseDTO
            );

            return ResponseEntity.status(HttpStatus.OK.value()).body(response);
      }
}
