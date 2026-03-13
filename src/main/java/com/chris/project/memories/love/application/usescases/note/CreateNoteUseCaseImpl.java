package com.chris.project.memories.love.application.usescases.note;

import org.springframework.stereotype.Component;

import com.chris.project.memories.love.domain.exceptions.UserNotFoundException;
import com.chris.project.memories.love.domain.models.Note;
import com.chris.project.memories.love.domain.models.User;
import com.chris.project.memories.love.domain.ports.in.note.CreateNoteUseCase;
import com.chris.project.memories.love.domain.ports.on.note.NoteRepositoryPort;
import com.chris.project.memories.love.domain.ports.on.user.UserRepositoryPort;

@Component
public class CreateNoteUseCaseImpl implements CreateNoteUseCase {
      
      private final NoteRepositoryPort noteRepository;
      private final UserRepositoryPort userRepository;

      public CreateNoteUseCaseImpl(NoteRepositoryPort noteRepository, UserRepositoryPort userRepository){
            this.noteRepository = noteRepository;
            this.userRepository = userRepository;
      }

      @Override
      public Note execute(Note note, String username){

            User user = userRepository.findByUsername(username)
                  .orElseThrow(() -> new UserNotFoundException("User not found: " + username));

            note.setUser(user);
            return noteRepository.save(note);
      }
}
