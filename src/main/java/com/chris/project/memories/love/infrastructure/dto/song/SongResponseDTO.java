package com.chris.project.memories.love.infrastructure.dto.song;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SongResponseDTO {

      private UUID id;
      private String url;
      private String message;
      @JsonProperty("created_at")
      private LocalDateTime createdAt;

      public UUID getId() {
            return id;
      }
      public void setId(UUID id) {
            this.id = id;
      }
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
      public LocalDateTime getCreatedAt() {
            return createdAt;
      }
      public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
      }
}
