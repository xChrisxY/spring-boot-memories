package com.chris.project.memories.love.application.usescases.note;

import java.util.List;

import org.springframework.stereotype.Component;

import com.chris.project.memories.love.domain.models.Note;
import com.chris.project.memories.love.domain.ports.in.note.ListNotesUseCase;
import com.chris.project.memories.love.domain.ports.on.note.NoteRepositoryPort;

@Component
public class ListNotesUseCaseImpl implements ListNotesUseCase {

      private final NoteRepositoryPort noteRepository;

      public ListNotesUseCaseImpl(NoteRepositoryPort noteRepository){
            this.noteRepository = noteRepository;
      }

      @Override
      public List<Note> execute(){
            return noteRepository.findAll();
      }
}
