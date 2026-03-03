package com.chris.project.memories.love.infrastructure.dto.lists;

import java.util.UUID;

import com.chris.project.memories.love.domain.enums.ItemStatus;

public class ListEnumResponseDTO {

      private UUID id;
      private String content;
      private ItemStatus status;

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
      public ItemStatus getStatus() {
            return status;
      }
      public void setStatus(ItemStatus status) {
            this.status = status;
      }
}
