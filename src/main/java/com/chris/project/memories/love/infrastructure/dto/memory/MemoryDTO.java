package com.chris.project.memories.love.infrastructure.dto.memory;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class MemoryDTO {

      @NotBlank
      private String imageUrl;
      @NotBlank
      @Min(3)
      @Column(unique = true)
      private String title;  
      private String description;

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
      
}
