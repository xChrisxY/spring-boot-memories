package com.chris.project.memories.love.infrastructure.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.project.memories.love.domain.models.Memory;
import com.chris.project.memories.love.domain.ports.in.memory.CreateMemoryUseCase;
import com.chris.project.memories.love.infrastructure.dto.ApiResponse;
import com.chris.project.memories.love.infrastructure.dto.memory.MemoryDTO;
import com.chris.project.memories.love.infrastructure.dto.memory.MemoryResponseDTO;
import com.chris.project.memories.love.infrastructure.mappers.memory.MemoryMapper;

@RestController
@RequestMapping("/api/memories")
public class MemoryController {

      private final CreateMemoryUseCase createMemoryUseCase;
      private final MemoryMapper memoryMapper;

      public MemoryController(CreateMemoryUseCase createMemoryUseCase, MemoryMapper memoryMapper){
            this.createMemoryUseCase = createMemoryUseCase;
            this.memoryMapper = memoryMapper;
      }

      @PostMapping
      public ResponseEntity<ApiResponse<MemoryResponseDTO>> create(@RequestBody MemoryDTO dto){

            Memory memory = memoryMapper.toDomain(dto);
            Memory newMemory = createMemoryUseCase.execute(memory);
            MemoryResponseDTO memoryResponseDTO = memoryMapper.toResponseDTO(newMemory);

            ApiResponse<MemoryResponseDTO> response = new ApiResponse<MemoryResponseDTO>(
                  true,
                  "memory created successfully",
                  201,
                  memoryResponseDTO
            );

            return ResponseEntity.status(HttpStatus.CREATED.value()).body(response);
      }
}
