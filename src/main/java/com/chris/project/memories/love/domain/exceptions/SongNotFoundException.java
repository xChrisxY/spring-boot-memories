package com.chris.project.memories.love.domain.exceptions;

public class SongNotFoundException extends RuntimeException {

      public SongNotFoundException(String message){
            super(message);
      }
}
