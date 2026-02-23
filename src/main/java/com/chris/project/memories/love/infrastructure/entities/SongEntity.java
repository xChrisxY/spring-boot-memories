package com.chris.project.memories.love.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "songs")
public class SongEntity {

      @Id
      @GeneratedValue(strategy = GenerationType.UUID)
      private UUID id;

      private String url;
      private String message;

      @Column(name = "created_at")
      private LocalDateTime createdAt;

      @ManyToOne
      @JoinColumn(name = "author_id")
      private UserEntity user;

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

      public UserEntity getUser() {
            return user;
      }

      public void setUser(UserEntity user) {
            this.user = user;
      }

}
