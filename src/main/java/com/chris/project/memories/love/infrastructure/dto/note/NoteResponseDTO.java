package com.chris.project.memories.love.infrastructure.dto.note;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NoteResponseDTO {

      private UUID id;
      private String content;
      @JsonProperty("created_at")
      private LocalDateTime createdAt;

      public UUID getId() {
            return id;
      }
      public void setId(UUID id) {
            this.id = id;
      }
      public String getContent() {
            return content;
      }
      public void setContent(String content) {
            this.content = content;
      }
      public LocalDateTime getCreatedAt() {
            return createdAt;
      }
      public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
      }
}
