package com.chris.project.memories.love.domain.exceptions;

public class NoteNotFoundException extends RuntimeException {

      public NoteNotFoundException(String message){
            super(message);
      }
}
