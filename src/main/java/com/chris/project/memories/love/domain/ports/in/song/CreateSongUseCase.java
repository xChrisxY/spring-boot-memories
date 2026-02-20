package com.chris.project.memories.love.domain.ports.in.song;

import com.chris.project.memories.love.domain.models.Song;

public interface CreateSongUseCase {
      Song execute(Song song);
}
