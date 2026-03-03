package com.chris.project.memories.love.infrastructure.repositories.adapters;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chris.project.memories.love.domain.models.Song;
import com.chris.project.memories.love.domain.ports.on.song.SongRepositoryPort;
import com.chris.project.memories.love.infrastructure.entities.SongEntity;
import com.chris.project.memories.love.infrastructure.mappers.song.SongPersistenceMapper;
import com.chris.project.memories.love.infrastructure.repositories.JpaSongRepository;


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

      @Override
      @Transactional(readOnly = true)
      public Optional<Song> getSongById(UUID uuid){

            return songRepository.findById(uuid)
                  .map(song -> songMapper.toDomain(song));
      }

      @Override
      @Transactional(readOnly = true)
      public List<Song> findAll(){

            return songRepository.findAll().stream()
                  .map(song -> songMapper.toDomain(song))
                  .collect(Collectors.toList());
      }

}
