package com.chris.project.memories.love.infrastructure.dto.lists;

import com.chris.project.memories.love.domain.enums.ListType;

public class CustomListDTO {

      private String title;
      private ListType type;

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
}
