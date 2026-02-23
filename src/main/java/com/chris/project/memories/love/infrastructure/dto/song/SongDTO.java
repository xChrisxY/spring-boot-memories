package com.chris.project.memories.love.infrastructure.dto.song;

import jakarta.validation.constraints.NotBlank;

public class SongDTO {

      @NotBlank
      private String url;
      @NotBlank
      private String message;

      public String getUrl() {
            return url;
      }
      public void setUrl(String url) {
            this.url = url;
      }
      public String getMessage() {
            return message;
      }
      public void setMessage(String message) {
            this.message = message;
      }
}
