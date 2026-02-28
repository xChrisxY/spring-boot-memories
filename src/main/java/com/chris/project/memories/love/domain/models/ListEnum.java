package com.chris.project.memories.love.domain.models;

import java.util.UUID;

import com.chris.project.memories.love.domain.enums.ItemStatus;

public class ListEnum {

      private UUID id;
      private String content;
      private ItemStatus status;
      private CustomList list;

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
      public CustomList getList() {
            return list;
      }
      public void setList(CustomList list) {
            this.list = list;
      }
}
