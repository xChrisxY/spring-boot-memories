package com.chris.project.memories.love.domain.ports.in.lists;

import java.util.List;

import com.chris.project.memories.love.domain.models.CustomList;

public interface FindAllCustomListsUseCase {
      List<CustomList> execute();
}
