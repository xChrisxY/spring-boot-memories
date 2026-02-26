package com.chris.project.memories.love.infrastructure.dto.note;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;

public class NoteDTO {

      @NotBlank
      private String content;

      public String getContent() {
            return content;
      }

      public void setContent(String content) {
            this.content = content;
      }
}
