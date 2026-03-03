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

import com.chris.project.memories.love.domain.models.CustomList;
import com.chris.project.memories.love.domain.models.ListEnum;
import com.chris.project.memories.love.domain.ports.in.lists.CreateCustomListUseCase;
import com.chris.project.memories.love.domain.ports.in.lists.CreateListEnumUseCase;
import com.chris.project.memories.love.domain.ports.in.lists.GetItemsByCustomListUseCase;
import com.chris.project.memories.love.infrastructure.dto.ApiResponse;
import com.chris.project.memories.love.infrastructure.dto.lists.CustomListDTO;
import com.chris.project.memories.love.infrastructure.dto.lists.CustomListResponseDTO;
import com.chris.project.memories.love.infrastructure.dto.lists.ListEnumDTO;
import com.chris.project.memories.love.infrastructure.dto.lists.ListEnumResponseDTO;
import com.chris.project.memories.love.infrastructure.mappers.lists.CustomListMapper;
import com.chris.project.memories.love.infrastructure.mappers.lists.ListEnumMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/lists")
public class CustomListController {

      private final CreateCustomListUseCase createCustomListUseCase;
      private final CreateListEnumUseCase createListEnumUseCase;
      private final GetItemsByCustomListUseCase getItemsByCustomListUseCase;
      private final CustomListMapper customListMapper;
      private final ListEnumMapper listEnumMapper;

      public CustomListController(
            CreateCustomListUseCase createCustomListUseCase, 
            CreateListEnumUseCase createListEnumUseCase,
            GetItemsByCustomListUseCase getItemsByCustomListUseCase,
            CustomListMapper customListMapper,
            ListEnumMapper listEnumMapper
      ){
            this.createCustomListUseCase = createCustomListUseCase;
            this.createListEnumUseCase = createListEnumUseCase;
            this.getItemsByCustomListUseCase = getItemsByCustomListUseCase;
            this.customListMapper = customListMapper;
            this.listEnumMapper = listEnumMapper;
      }

      @PostMapping
      public ResponseEntity<ApiResponse<CustomListResponseDTO>> create(@Valid @RequestBody CustomListDTO dto){

            CustomList customList = customListMapper.toDomain(dto);
            CustomList newCustomList = createCustomListUseCase.execute(customList);
            CustomListResponseDTO customListResponseDTO = customListMapper.toResponseDTO(newCustomList);

            ApiResponse<CustomListResponseDTO> response = new ApiResponse<CustomListResponseDTO>(
                  true, 
                  "Lista creada correctamente", 
                  201, 
                  customListResponseDTO
            );

            return ResponseEntity.status(HttpStatus.CREATED.value()).body(response);
      }

      @PostMapping("/{customListUUID}")
      public ResponseEntity<ApiResponse<ListEnumResponseDTO>> createListEnum(@PathVariable UUID customListUUID, @Valid @RequestBody ListEnumDTO dto){

            ListEnum listEnum = listEnumMapper.toDomain(dto);           
            ListEnum newListEnum = createListEnumUseCase.execute(customListUUID, listEnum);
            ListEnumResponseDTO listEnumResponseDTO = listEnumMapper.toResponseDTO(newListEnum);

            ApiResponse<ListEnumResponseDTO> response = new ApiResponse<ListEnumResponseDTO>(
                  true, 
                  "El item se ha añadido a tu lista", 
                  201, 
                  listEnumResponseDTO
            );

            return ResponseEntity.status(HttpStatus.CREATED.value()).body(response);
      }

      @GetMapping("/{uuid}")
      public ResponseEntity<ApiResponse<List<ListEnumResponseDTO>>> getItemsByListId(@PathVariable UUID uuid){

            List<ListEnum> listItems = getItemsByCustomListUseCase.execute(uuid);
            List<ListEnumResponseDTO> listEnumResponseDTOs = listEnumMapper.toListResponseDTO(listItems);

            ApiResponse<List<ListEnumResponseDTO>> response = new ApiResponse<List<ListEnumResponseDTO>>(
                  true, 
                  "Items obtenidos éxitosamente", 
                  200, 
                  listEnumResponseDTOs
            );

            return ResponseEntity.status(HttpStatus.CREATED.value()).body(response);
      }
}
