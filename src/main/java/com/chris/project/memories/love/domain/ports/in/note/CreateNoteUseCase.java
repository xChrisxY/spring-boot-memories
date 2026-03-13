package com.chris.project.memories.love.domain.ports.in.note;

import com.chris.project.memories.love.domain.models.Note;

public interface CreateNoteUseCase {
      Note execute(Note note, String username);
}
