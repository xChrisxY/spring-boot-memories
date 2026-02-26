package com.chris.project.memories.love.infrastructure.repositories.adapters;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chris.project.memories.love.domain.models.Note;
import com.chris.project.memories.love.domain.ports.on.note.NoteRepositoryPort;
import com.chris.project.memories.love.infrastructure.entities.NoteEntity;
import com.chris.project.memories.love.infrastructure.mappers.note.NotePersistenceMapper;
import com.chris.project.memories.love.infrastructure.repositories.JpaNoteRepository;


@Repository
public class JpaNoteRepositoryAdapter implements NoteRepositoryPort {

      private final JpaNoteRepository noteRepository;
      private final NotePersistenceMapper noteMapper;

      public JpaNoteRepositoryAdapter(JpaNoteRepository noteRepository, NotePersistenceMapper noteMapper){
            this.noteRepository = noteRepository;
            this.noteMapper = noteMapper;
      }


      @Override
      @Transactional
      public Note save(Note note){

            NoteEntity entity = noteMapper.toEntity(note);
            NoteEntity newEntity = noteRepository.save(entity);
            return noteMapper.toDomain(newEntity);

      }

      @Override
      @Transactional(readOnly = true)
      public Optional<Note> findByUUID(UUID uuid){
            return noteRepository.findById(uuid)
                  .map(note -> noteMapper.toDomain(note));
      }

      @Override
      @Transactional(readOnly = true)
      public List<Note> findAll(){

            return noteRepository.findAll().stream()
                  .map(note -> noteMapper.toDomain(note))
                  .collect(Collectors.toList());
      }
}
