package com.chris.project.memories.love.domain.ports.in.song;

import java.util.List;

import com.chris.project.memories.love.domain.models.Song;

public interface FindAllSongsUseCase {
      List<Song> execute();
}
