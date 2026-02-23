package com.chris.project.memories.love.domain.ports.on.note;

import com.chris.project.memories.love.domain.models.Note;

public interface NoteRepositoryPort {
      Note save(Note note);
}
