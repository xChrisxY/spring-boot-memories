package com.chris.project.memories.love.infrastructure.controllers;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chris.project.memories.love.domain.models.Memory;
import com.chris.project.memories.love.domain.ports.in.memory.CreateMemoryUseCase;
import com.chris.project.memories.love.domain.ports.in.memory.GetMemoryByUUIDUseCase;
import com.chris.project.memories.love.domain.ports.in.memory.ListMemoriesUseCase;
import com.chris.project.memories.love.infrastructure.dto.ApiResponse;
import com.chris.project.memories.love.infrastructure.dto.memory.MemoryResponseDTO;
import com.chris.project.memories.love.infrastructure.mappers.memory.MemoryMapper;
import com.chris.project.memories.love.infrastructure.security.utils.SecurityUtils;

@RestController
@RequestMapping("/api/memories")
public class MemoryController {

      private final CreateMemoryUseCase createMemoryUseCase;
      private final GetMemoryByUUIDUseCase getMemoryByUUIDUseCase;
      private final ListMemoriesUseCase listMemoriesUseCase;
      private final MemoryMapper memoryMapper;

      public MemoryController(
            CreateMemoryUseCase createMemoryUseCase, 
            GetMemoryByUUIDUseCase getMemoryByUUIDUseCase,
            ListMemoriesUseCase listMemoriesUseCase,
            MemoryMapper memoryMapper
      ){
            this.createMemoryUseCase = createMemoryUseCase;
            this.getMemoryByUUIDUseCase = getMemoryByUUIDUseCase;
            this.listMemoriesUseCase = listMemoriesUseCase;
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

      @GetMapping("/{uuid}")
      public ResponseEntity<ApiResponse<MemoryResponseDTO>> getById(@PathVariable UUID uuid){

            Memory memory = getMemoryByUUIDUseCase.execute(uuid);
            MemoryResponseDTO memoryResponseDTO = memoryMapper.toResponseDTO(memory);

            ApiResponse<MemoryResponseDTO> response = new ApiResponse<MemoryResponseDTO>(
                  true, 
                  "Recuerdo obtenido satisfactoriamente", 
                  200, 
                  memoryResponseDTO
            );

            return ResponseEntity.status(HttpStatus.OK.value()).body(response);
      }

      @GetMapping
      public ResponseEntity<ApiResponse<List<MemoryResponseDTO>>> list(){

            List<Memory> memories = listMemoriesUseCase.execute();
            List<MemoryResponseDTO> responseDTOs = memoryMapper.toResponseDTOToList(memories);

            ApiResponse<List<MemoryResponseDTO>> response = new ApiResponse<List<MemoryResponseDTO>>(
                  true, 
                  "memorias obtenidas satisfactoriamente", 
                  200, 
                  responseDTOs
            );

            return ResponseEntity.status(HttpStatus.OK.value()).body(response);
      }

}
