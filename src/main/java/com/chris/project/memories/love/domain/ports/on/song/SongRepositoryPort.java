package com.chris.project.memories.love.domain.ports.on.song;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.chris.project.memories.love.domain.models.Song;

public interface SongRepositoryPort {
      Song save(Song song);
      Optional<Song> getSongById(UUID uuid);
      List<Song> findAll();
}
