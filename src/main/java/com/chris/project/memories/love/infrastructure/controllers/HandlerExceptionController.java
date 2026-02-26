package com.chris.project.memories.love.infrastructure.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.chris.project.memories.love.domain.exceptions.MemoryNotFoundException;
import com.chris.project.memories.love.domain.exceptions.NoteNotFoundException;
import com.chris.project.memories.love.domain.exceptions.RoleNotFoundException;
import com.chris.project.memories.love.domain.exceptions.SongNotFoundException;
import com.chris.project.memories.love.domain.exceptions.UserNotFoundException;
import com.chris.project.memories.love.infrastructure.dto.ApiResponse;

@RestControllerAdvice
public class HandlerExceptionController {

      @ExceptionHandler({MethodArgumentNotValidException.class})
      public ResponseEntity<ApiResponse<Map<String, Object>>> methodArgumentNotValid(MethodArgumentNotValidException e){

            Map<String, Object> errors = new HashMap<>();
            List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();

            fieldErrors.forEach(error -> {
                  errors.put(error.getField(), "El campo " + error.getField() + " " + error.getDefaultMessage());
            });

            ApiResponse<Map<String, Object>> response = new ApiResponse<>(
                  false, 
                  "Error de validación en el cuerpo de la petición", 
                  HttpStatus.FORBIDDEN.value(), 
                  errors
            );

            return ResponseEntity.status(HttpStatus.FORBIDDEN.value()).body(response);
      }

      @ExceptionHandler({
            MemoryNotFoundException.class, 
            RoleNotFoundException.class, 
            SongNotFoundException.class, 
            UserNotFoundException.class, 
            NoteNotFoundException.class
      })
      public ResponseEntity<ApiResponse<String>> entityNotFound(Exception e){

            ApiResponse<String> response = new ApiResponse<>(
                  false, 
                  "Error de validación en el cuerpo de la petición", 
                  HttpStatus.FORBIDDEN.value(), 
                  e.getMessage()
            );

            return ResponseEntity.status(HttpStatus.FORBIDDEN.value()).body(response);

      }
}
