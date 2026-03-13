package com.chris.project.memories.love.domain.ports.in.note;

import java.util.UUID;

import com.chris.project.memories.love.domain.models.Note;

public interface GetNoteByUUIDUseCase {
      Note execute(UUID uuid);
}
