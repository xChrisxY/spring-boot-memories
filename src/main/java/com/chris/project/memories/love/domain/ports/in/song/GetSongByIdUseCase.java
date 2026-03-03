package com.chris.project.memories.love.domain.ports.in.song;

import java.util.UUID;

import com.chris.project.memories.love.domain.models.Song;

public interface GetSongByIdUseCase {
      Song execute(UUID uuid);
}
