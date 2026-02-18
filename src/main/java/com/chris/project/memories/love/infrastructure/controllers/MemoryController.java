package com.chris.project.memories.love.infrastructure.controllers;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chris.project.memories.love.domain.models.Memory;
import com.chris.project.memories.love.domain.ports.in.memory.CreateMemoryUseCase;
import com.chris.project.memories.love.infrastructure.dto.ApiResponse;
import com.chris.project.memories.love.infrastructure.dto.memory.MemoryDTO;
import com.chris.project.memories.love.infrastructure.dto.memory.MemoryResponseDTO;
import com.chris.project.memories.love.infrastructure.mappers.memory.MemoryMapper;
import com.chris.project.memories.love.infrastructure.security.utils.SecurityUtils;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/memories")
public class MemoryController {

      private final CreateMemoryUseCase createMemoryUseCase;
      private final MemoryMapper memoryMapper;

      public MemoryController(CreateMemoryUseCase createMemoryUseCase, MemoryMapper memoryMapper){
            this.createMemoryUseCase = createMemoryUseCase;
            this.memoryMapper = memoryMapper;
      }

      @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
      public ResponseEntity<ApiResponse<MemoryResponseDTO>> create(

            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("image") MultipartFile image

      ) throws IOException{

            Memory memory = new Memory(title, description);
            String userCreator = SecurityUtils.getCurrentUsername();
            Memory newMemory = createMemoryUseCase.execute(memory, userCreator, image.getBytes(), image.getOriginalFilename());
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
