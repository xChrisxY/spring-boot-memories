package com.chris.project.memories.love.infrastructure.dto.user;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDTO {

      @NotBlank
      @Size(min = 5, max = 20)
      private String username;

      @NotBlank
      @Size(min = 5, max = 20)
      private String password;

      @NotBlank
      @Size(min = 5, max = 20)
      @Column(unique = true)
      private String email;

      public String getUsername() {
            return username;
      }
      public void setUsername(String username) {
            this.username = username;
      }
      public String getPassword() {
            return password;
      }
      public void setPassword(String password) {
            this.password = password;
      }
      public String getEmail() {
            return email;
      }
      public void setEmail(String email) {
            this.email = email;
      }

}
