package com.chris.project.memories.love.application.usescases.lists;

import org.springframework.stereotype.Component;

import com.chris.project.memories.love.domain.models.CustomList;
import com.chris.project.memories.love.domain.ports.in.lists.CreateCustomListUseCase;
import com.chris.project.memories.love.domain.ports.on.lists.CustomListRepositoryPort;

@Component
public class CreateCustomListUseCaseImpl implements CreateCustomListUseCase {

      private CustomListRepositoryPort customListRepository;

      public CreateCustomListUseCaseImpl(CustomListRepositoryPort customListRepository){
            this.customListRepository = customListRepository;
      }

      @Override
      public CustomList execute(CustomList customList){
            
            return customListRepository.save(customList);
      }

}
