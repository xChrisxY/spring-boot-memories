package com.chris.project.memories.love.application.usescases.song;

import java.util.List;

import org.springframework.stereotype.Component;

import com.chris.project.memories.love.domain.models.Song;
import com.chris.project.memories.love.domain.ports.in.song.FindAllSongsUseCase;
import com.chris.project.memories.love.domain.ports.on.song.SongRepositoryPort;

@Component
public class FindAllSongsUseCaseImpl implements FindAllSongsUseCase{

      private final SongRepositoryPort songRepository;

      public FindAllSongsUseCaseImpl(SongRepositoryPort songRepository){
            this.songRepository = songRepository;
      }

      @Override
      public List<Song> execute(){
            return songRepository.findAll();
      }
}
