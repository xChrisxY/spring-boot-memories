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

import com.chris.project.memories.love.domain.models.Song;
import com.chris.project.memories.love.domain.ports.in.song.CreateSongUseCase;
import com.chris.project.memories.love.domain.ports.in.song.FindAllSongsUseCase;
import com.chris.project.memories.love.domain.ports.in.song.GetSongByIdUseCase;
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
      private final GetSongByIdUseCase getSongByIdUseCase;
      private final FindAllSongsUseCase findAllSongsUseCase;
      private final SongMapper songMapper;

      public SongController(
            CreateSongUseCase createSongUseCase, 
            GetSongByIdUseCase getSongByIdUseCase,
            FindAllSongsUseCase findAllSongsUseCase,
            SongMapper songMapper
      ){
            this.createSongUseCase = createSongUseCase;
            this.getSongByIdUseCase = getSongByIdUseCase;
            this.findAllSongsUseCase = findAllSongsUseCase;
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

      @GetMapping("/{uuid}")
      public ResponseEntity<ApiResponse<SongResponseDTO>> findById(@PathVariable UUID uuid){

            Song song = getSongByIdUseCase.execute(uuid);
            SongResponseDTO songResponseDTO = songMapper.toResponseDTO(song);

            ApiResponse<SongResponseDTO> response = new ApiResponse<SongResponseDTO>(
                  true, 
                  "Canción obtenida satisfactoriamente", 
                  200, 
                  songResponseDTO
            );

            return ResponseEntity.status(HttpStatus.OK.value()).body(response);
      }

      @GetMapping
      public ResponseEntity<ApiResponse<List<SongResponseDTO>>> findAll(){

            List<Song> songs = findAllSongsUseCase.execute();
            List<SongResponseDTO> songResponseDTOs = songMapper.toListResponseDTO(songs);

            ApiResponse<List<SongResponseDTO>> response = new ApiResponse<List<SongResponseDTO>>(
                  true, 
                  "Canción obtenida satisfactoriamente", 
                  200, 
                  songResponseDTOs
            );

            return ResponseEntity.status(HttpStatus.OK.value()).body(response);
      }
}
