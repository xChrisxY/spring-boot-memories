package com.chris.project.memories.love.infrastructure.repositories.adapters;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chris.project.memories.love.domain.models.CustomList;
import com.chris.project.memories.love.domain.models.ListEnum;
import com.chris.project.memories.love.domain.ports.on.lists.CustomListRepositoryPort;
import com.chris.project.memories.love.infrastructure.entities.CustomListEntity;
import com.chris.project.memories.love.infrastructure.mappers.lists.CustomListPersistenceMapper;
import com.chris.project.memories.love.infrastructure.mappers.lists.ListEnumMapper;
import com.chris.project.memories.love.infrastructure.mappers.lists.ListEnumPersistenceMapper;
import com.chris.project.memories.love.infrastructure.repositories.JpaCustomListRepository;
import com.chris.project.memories.love.infrastructure.repositories.JpaListEnumRepository;


@Repository
public class JpaCustomListRepositoryAdapter implements CustomListRepositoryPort {

      private final JpaCustomListRepository customListRepository;
      private final JpaListEnumRepository listEnumRepository;
      private final CustomListPersistenceMapper customListMapper;
      private final ListEnumPersistenceMapper listEnumMapper;

      public JpaCustomListRepositoryAdapter(
            JpaCustomListRepository customListRepository, 
            JpaListEnumRepository listEnumRepository,
            CustomListPersistenceMapper customListMapper,
            ListEnumPersistenceMapper listEnumMapper
      ){
            this.customListRepository = customListRepository;
            this.listEnumRepository = listEnumRepository;
            this.customListMapper = customListMapper;
            this.listEnumMapper = listEnumMapper;
      }

      @Override
      @Transactional
      public CustomList save(CustomList customList){
            CustomListEntity entity = customListMapper.toEntity(customList);
            CustomListEntity newEntity = customListRepository.save(entity);
            return customListMapper.toDomain(newEntity);
      }

      @Override
      @Transactional(readOnly = true)
      public Optional<CustomList> findById(UUID uuid) {
            return customListRepository.findById(uuid)
                  .map(customList -> customListMapper.toDomain(customList));
      }

      @Override
      @Transactional(readOnly = true)
      public List<ListEnum> getListEnumByCustomListUUID(UUID uuid){

            return listEnumRepository.findByListId(uuid).stream()
                  .map(listEnum -> listEnumMapper.toDomain(listEnum))
                  .collect(Collectors.toList());
      }

      @Override
      @Transactional(readOnly = true)
      public List<CustomList> findAll(){
            return customListRepository.findAll().stream() 
                  .map(customList -> customListMapper.toDomain(customList)) 
                  .collect(Collectors.toList());
      }

}
