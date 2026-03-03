package com.chris.project.memories.love.application.usescases.song;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.chris.project.memories.love.domain.exceptions.SongNotFoundException;
import com.chris.project.memories.love.domain.models.Song;
import com.chris.project.memories.love.domain.ports.in.song.GetSongByIdUseCase;
import com.chris.project.memories.love.domain.ports.on.song.SongRepositoryPort;

@Component
public class GetSongByIdUseCaseImpl implements GetSongByIdUseCase {

      private final SongRepositoryPort songRepository;

      public GetSongByIdUseCaseImpl(SongRepositoryPort songRepository){
            this.songRepository = songRepository;
      }

      @Override
      public Song execute(UUID uuid){
            return songRepository.getSongById(uuid)
                  .orElseThrow(() -> new SongNotFoundException("No se encontró una canción con ese UUID"));
      }
}
