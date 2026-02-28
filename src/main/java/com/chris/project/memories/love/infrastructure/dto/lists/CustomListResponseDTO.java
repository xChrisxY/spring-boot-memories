package com.chris.project.memories.love.infrastructure.dto.lists;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.type.ListType;

public class CustomListResponseDTO {

      private UUID id;
      private String title;
      private ListType type;
      private LocalDateTime createdAt;

      public UUID getId() {
            return id;
      }
      public void setId(UUID id) {
            this.id = id;
      }
      public String getTitle() {
            return title;
      }
      public void setTitle(String title) {
            this.title = title;
      }
      public ListType getType() {
            return type;
      }
      public void setType(ListType type) {
            this.type = type;
      }
      public LocalDateTime getCreatedAt() {
            return createdAt;
      }
      public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
      } 
}
