package com.chris.project.memories.love.infrastructure.repositories.adapters;

import org.springframework.stereotype.Repository;

import com.chris.project.memories.love.domain.models.Song;
import com.chris.project.memories.love.domain.ports.on.song.SongRepositoryPort;
import com.chris.project.memories.love.infrastructure.entities.SongEntity;
import com.chris.project.memories.love.infrastructure.mappers.song.SongPersistenceMapper;
import com.chris.project.memories.love.infrastructure.repositories.JpaSongRepository;

import jakarta.transaction.Transactional;

@Repository
public class JpaSongRepositoryAdapter implements SongRepositoryPort{

      private final JpaSongRepository songRepository;
      private final SongPersistenceMapper songMapper;

      public JpaSongRepositoryAdapter(JpaSongRepository songRepository, SongPersistenceMapper songMapper){
            this.songRepository = songRepository;
            this.songMapper = songMapper;
      }

      @Override
      @Transactional
      public Song save(Song song){

            SongEntity entity = songMapper.toEntity(song);
            SongEntity newEntity = songRepository.save(entity);
            return songMapper.toDomain(newEntity);

      }

}
