package com.chris.project.memories.love.domain.ports.on.note;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.chris.project.memories.love.domain.models.Note;

public interface NoteRepositoryPort {
      Note save(Note note);
      Optional<Note> findByUUID(UUID uuid);
      List<Note> findAll();
}
