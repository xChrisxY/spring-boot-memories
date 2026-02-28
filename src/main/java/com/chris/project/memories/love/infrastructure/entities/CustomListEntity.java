package com.chris.project.memories.love.infrastructure.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import com.chris.project.memories.love.domain.enums.ListType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lists")
public class CustomListEntity {

      @Id
      @GeneratedValue(strategy = GenerationType.UUID)
      private UUID id;

      @Column(nullable = false)
      private String title;

      @Enumerated(EnumType.STRING)
      private ListType type;

      @Column(nullable = false)
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
