package com.chris.project.memories.love.domain.ports.on.song;

import com.chris.project.memories.love.domain.models.Song;

public interface SongRepositoryPort {
      Song save(Song song);
}
