package com.chris.project.memories.love.domain.models;

import java.time.LocalDateTime;
import java.util.UUID;

import com.chris.project.memories.love.domain.enums.ListType;

public class CustomList {

      private UUID id;
      private String title;
      private ListType type;
      private LocalDateTime createdAt;

      public CustomList(){
            this.createdAt = LocalDateTime.now();
      }

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
