package com.chris.project.memories.love.infrastructure.repositories.adapters;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chris.project.memories.love.domain.models.ListEnum;
import com.chris.project.memories.love.domain.ports.on.lists.ListEnumRepositoryPort;
import com.chris.project.memories.love.infrastructure.entities.ListEnumEntity;
import com.chris.project.memories.love.infrastructure.mappers.lists.ListEnumPersistenceMapper;
import com.chris.project.memories.love.infrastructure.repositories.JpaListEnumRepository;

@Repository
public class JpaListEnumRepositoryAdapter implements ListEnumRepositoryPort {

      private final JpaListEnumRepository listEnumRepository;
      private final ListEnumPersistenceMapper listEnumMapper;

      public JpaListEnumRepositoryAdapter(JpaListEnumRepository listEnumRepository, ListEnumPersistenceMapper listEnumMapper){
            this.listEnumRepository = listEnumRepository;
            this.listEnumMapper = listEnumMapper;
      }

      @Override
      @Transactional
      public ListEnum save(ListEnum listEnum){
            
            ListEnumEntity listEnumEntity = listEnumMapper.toEntity(listEnum);
            ListEnumEntity newListEnumEntity = listEnumRepository.save(listEnumEntity);
            return listEnumMapper.toDomain(newListEnumEntity);
      }
      
}
