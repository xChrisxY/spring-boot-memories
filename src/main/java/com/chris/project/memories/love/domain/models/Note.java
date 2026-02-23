package com.chris.project.memories.love.domain.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Note {

      private UUID id;
      private String content;
      private LocalDateTime createdAt;
      private User user;

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
      public User getUser() {
            return user;
      }
      public void setUser(User user) {
            this.user = user;
      }
}
