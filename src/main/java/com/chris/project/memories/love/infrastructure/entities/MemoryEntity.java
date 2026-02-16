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
@Table(name = "memories")
public class MemoryEntity {

      @Id
      @GeneratedValue(strategy = GenerationType.UUID)
      private UUID id;
      @Column(name = "image_url")
      private String imageUrl;
      private String title;  
      private String description;
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
      public UserEntity getUser() {
            return user;
      }
      public void setUser(UserEntity user) {
            this.user = user;
      }

      
}
