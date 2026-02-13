package com.chris.project.memories.love.domain.models;

import java.util.UUID;

public class User {

      private UUID id;
      private String username;
      private String passwordHash;
      private String email;

      public UUID getId() {
            return id;
      }
      public void setId(UUID id) {
            this.id = id;
      }
      public String getUsername() {
            return username;
      }
      public void setUsername(String username) {
            this.username = username;
      }
      public String getPasswordHash() {
            return passwordHash;
      }
      public void setPasswordHash(String passwordHash) {
            this.passwordHash = passwordHash;
      }
      public String getEmail() {
            return email;
      }
      public void setEmail(String email) {
            this.email = email;
      }

}
