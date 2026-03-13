package com.chris.project.memories.love.application.usescases.lists;

import java.util.List;

import org.springframework.stereotype.Component;

import com.chris.project.memories.love.domain.models.CustomList;
import com.chris.project.memories.love.domain.ports.in.lists.FindAllCustomListsUseCase;
import com.chris.project.memories.love.domain.ports.on.lists.CustomListRepositoryPort;

@Component
public class FindAllCustomListUseCaseImpl implements FindAllCustomListsUseCase {

      private final CustomListRepositoryPort customListRepository;

      public FindAllCustomListUseCaseImpl(CustomListRepositoryPort customListRepository){
            this.customListRepository = customListRepository;
      }

      @Override
      public List<CustomList> execute(){
            return customListRepository.findAll();
      }
}
