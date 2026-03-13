package com.chris.project.memories.love.domain.ports.in.note;

import java.util.List;

import com.chris.project.memories.love.domain.models.Note;

public interface ListNotesUseCase {
      List<Note> execute();
}
