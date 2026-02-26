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
@Table(name = "notes")
public class NoteEntity {
      
      @Id
      @GeneratedValue(strategy = GenerationType.UUID)
      private UUID id;

      @Column(nullable = false, length = 3000)
      private String content;

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

      public UserEntity getUser() {
            return user;
      }

      public void setUser(UserEntity user) {
            this.user = user;
      }
}
