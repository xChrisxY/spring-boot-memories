package com.chris.project.memories.love.application.usescases.song;

import org.springframework.stereotype.Component;

import com.chris.project.memories.love.domain.models.Song;
import com.chris.project.memories.love.domain.ports.in.song.CreateSongUseCase;
import com.chris.project.memories.love.domain.ports.on.song.SongRepositoryPort;

@Component
public class CreateSongUseCaseImpl implements CreateSongUseCase {

      private final SongRepositoryPort songRepository;

      public CreateSongUseCaseImpl(SongRepositoryPort songRepository){
            this.songRepository = songRepository;
      }

      @Override
      public Song execute(Song song) {
            return songRepository.save(song);
      }

}
