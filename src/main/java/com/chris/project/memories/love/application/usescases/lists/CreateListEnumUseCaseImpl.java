package com.chris.project.memories.love.application.usescases.lists;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.chris.project.memories.love.domain.exceptions.CustomListNotFoundException;
import com.chris.project.memories.love.domain.models.CustomList;
import com.chris.project.memories.love.domain.models.ListEnum;
import com.chris.project.memories.love.domain.ports.in.lists.CreateListEnumUseCase;
import com.chris.project.memories.love.domain.ports.on.lists.CustomListRepositoryPort;
import com.chris.project.memories.love.domain.ports.on.lists.ListEnumRepositoryPort;

@Component
public class CreateListEnumUseCaseImpl implements CreateListEnumUseCase {

      private final ListEnumRepositoryPort listEnumRepository;
      private final CustomListRepositoryPort customListRepository;

      public CreateListEnumUseCaseImpl(ListEnumRepositoryPort listEnumRepository, CustomListRepositoryPort customListRepository){
            this.listEnumRepository = listEnumRepository;
            this.customListRepository = customListRepository;
      }

      @Override
      public ListEnum execute(UUID customListUUID, ListEnum listEnum){
            
            CustomList customList = customListRepository.findById(customListUUID)
                  .orElseThrow(() -> new CustomListNotFoundException("La lista no ha sido encontrada " + customListUUID));

            listEnum.setList(customList);
            return listEnumRepository.save(listEnum);
      }
}
