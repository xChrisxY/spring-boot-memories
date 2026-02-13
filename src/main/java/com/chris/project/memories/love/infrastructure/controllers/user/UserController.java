package com.chris.project.memories.love.infrastructure.controllers.user;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chris.project.memories.love.domain.models.User;
import com.chris.project.memories.love.domain.ports.in.CreateUserUseCase;
import com.chris.project.memories.love.infrastructure.dto.ApiResponse;
import com.chris.project.memories.love.infrastructure.dto.user.UserDTO;
import com.chris.project.memories.love.infrastructure.dto.user.UserResponseDTO;
import com.chris.project.memories.love.infrastructure.mappers.user.UserMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

      private final CreateUserUseCase createUserUseCase;
      private final UserMapper userMapper;

      public UserController(CreateUserUseCase createUserUseCase, UserMapper userMapper){
            this.createUserUseCase = createUserUseCase;
            this.userMapper = userMapper;
      }

      @PostMapping
      public ResponseEntity<ApiResponse<UserResponseDTO>> create(@Valid @RequestBody UserDTO dto){

            User user = userMapper.toDomain(dto);
            User newUser = createUserUseCase.execute(user);
            UserResponseDTO userResponseDTO = userMapper.toResponseDTO(newUser);

            ApiResponse<UserResponseDTO> response = new ApiResponse<UserResponseDTO>(
                  true,
                  "User created successfully",
                  200,
                  userResponseDTO
            );

            return ResponseEntity.status(HttpStatus.CREATED.value()).body(response);
      }

}
