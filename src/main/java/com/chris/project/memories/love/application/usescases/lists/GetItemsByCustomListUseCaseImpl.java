package com.chris.project.memories.love.application.usescases.lists;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.chris.project.memories.love.domain.exceptions.CustomListNotFoundException;
import com.chris.project.memories.love.domain.models.ListEnum;
import com.chris.project.memories.love.domain.ports.in.lists.GetItemsByCustomListUseCase;
import com.chris.project.memories.love.domain.ports.on.lists.CustomListRepositoryPort;

@Component
public class GetItemsByCustomListUseCaseImpl implements GetItemsByCustomListUseCase {

      private final CustomListRepositoryPort customListRepository;

      public GetItemsByCustomListUseCaseImpl(CustomListRepositoryPort customListRepository){
            this.customListRepository = customListRepository;
      }

      @Override
      public List<ListEnum> execute(UUID customListUUID){

            return customListRepository.getListEnumByCustomListUUID(customListUUID);
      }
}
