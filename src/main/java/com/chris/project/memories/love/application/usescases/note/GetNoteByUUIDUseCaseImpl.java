package com.chris.project.memories.love.application.usescases.note;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.chris.project.memories.love.domain.exceptions.NoteNotFoundException;
import com.chris.project.memories.love.domain.models.Note;
import com.chris.project.memories.love.domain.ports.in.note.GetNoteByUUIDUseCase;
import com.chris.project.memories.love.domain.ports.on.note.NoteRepositoryPort;

@Component
public class GetNoteByUUIDUseCaseImpl implements GetNoteByUUIDUseCase {

      private final NoteRepositoryPort noteRepository;

      public GetNoteByUUIDUseCaseImpl(NoteRepositoryPort noteRepository){
            this.noteRepository = noteRepository;
      }

      @Override
      public Note execute(UUID uuid){

            return noteRepository.findByUUID(uuid)
                  .orElseThrow(() -> new NoteNotFoundException("Nota no encontrada: " + uuid));

      }

}
