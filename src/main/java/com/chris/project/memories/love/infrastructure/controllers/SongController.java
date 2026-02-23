package com.chris.project.memories.love.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.project.memories.love.domain.models.Song;
import com.chris.project.memories.love.domain.ports.in.song.CreateSongUseCase;
import com.chris.project.memories.love.infrastructure.dto.ApiResponse;
import com.chris.project.memories.love.infrastructure.dto.song.SongDTO;
import com.chris.project.memories.love.infrastructure.dto.song.SongResponseDTO;
import com.chris.project.memories.love.infrastructure.mappers.song.SongMapper;
import com.chris.project.memories.love.infrastructure.security.utils.SecurityUtils;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/songs")
public class SongController {

      private final CreateSongUseCase createSongUseCase;
      private final SongMapper songMapper;

      public SongController(CreateSongUseCase createSongUseCase, SongMapper songMapper){
            this.createSongUseCase = createSongUseCase;
            this.songMapper = songMapper;
      }

      @PostMapping
      public ResponseEntity<ApiResponse<SongResponseDTO>> create(@Valid @RequestBody SongDTO dto) {
            
            Song song = songMapper.toDomain(dto);
            String username = SecurityUtils.getCurrentUsername();
            Song newSong = createSongUseCase.execute(song, username);

            SongResponseDTO songResponseDTO = songMapper.toResponseDTO(newSong);
            ApiResponse<SongResponseDTO> response = new ApiResponse<SongResponseDTO>(
                  true, 
                  "Canción creada correctamente", 
                  201, 
                  songResponseDTO
            );

            return ResponseEntity.status(HttpStatus.CREATED.value()).body(response);

      }

}
