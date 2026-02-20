package com.chris.project.memories.love.domain.models;

import java.time.LocalDateTime;
import java.util.UUID;

public class Song {

      private UUID id;
      private String url;
      private String message;
      private LocalDateTime createdAt;
      private User user;

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
      public User getUser() {
            return user;
      }
      public void setUser(User user) {
            this.user = user;
      }

}
