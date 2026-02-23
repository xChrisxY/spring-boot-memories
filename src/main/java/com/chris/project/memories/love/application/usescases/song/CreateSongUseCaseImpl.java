package com.chris.project.memories.love.application.usescases.song;

import org.springframework.stereotype.Component;

import com.chris.project.memories.love.domain.exceptions.UserNotFoundException;
import com.chris.project.memories.love.domain.models.Song;
import com.chris.project.memories.love.domain.models.User;
import com.chris.project.memories.love.domain.ports.in.song.CreateSongUseCase;
import com.chris.project.memories.love.domain.ports.on.song.SongRepositoryPort;
import com.chris.project.memories.love.domain.ports.on.user.UserRepositoryPort;

@Component
public class CreateSongUseCaseImpl implements CreateSongUseCase {

      private final SongRepositoryPort songRepository;
      private final UserRepositoryPort userRepository;

      public CreateSongUseCaseImpl(SongRepositoryPort songRepository, UserRepositoryPort userRepository){
            this.songRepository = songRepository;
            this.userRepository = userRepository;
      }

      @Override
      public Song execute(Song song, String username) {

            User user = userRepository.findByUsername(username)
                  .orElseThrow(() -> new UserNotFoundException("El usuario no fue encontrado:" + username)); 

            song.setUser(user);
            return songRepository.save(song);
      }

}
