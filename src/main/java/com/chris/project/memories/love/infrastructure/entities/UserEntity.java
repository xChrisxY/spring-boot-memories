package com.chris.project.memories.love.infrastructure.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserEntity {

      @Id
      @GeneratedValue(strategy = GenerationType.UUID)
      private UUID id;

      @Column(nullable = false)
      private String username;

      @Column(name = "password_hash")
      private String passwordHash;

      @Column(unique = true)
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
