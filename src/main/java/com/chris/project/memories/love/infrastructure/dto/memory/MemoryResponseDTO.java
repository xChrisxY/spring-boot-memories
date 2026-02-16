package com.chris.project.memories.love.infrastructure.dto.memory;

import java.time.LocalDateTime;
import java.util.UUID;

public class MemoryResponseDTO {

      private UUID id;
      private String imageUrl;
      private String title;  
      private String description;
      private LocalDateTime createdAt;

      public UUID getId() {
            return id;
      }
      public void setId(UUID id) {
            this.id = id;
      }
      public String getImageUrl() {
            return imageUrl;
      }
      public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
      }
      public String getTitle() {
            return title;
      }
      public void setTitle(String title) {
            this.title = title;
      }
      public String getDescription() {
            return description;
      }
      public void setDescription(String description) {
            this.description = description;
      }
      public LocalDateTime getCreatedAt() {
            return createdAt;
      }
      public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
      }

}
