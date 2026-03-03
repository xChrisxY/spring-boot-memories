package com.chris.project.memories.love.domain.ports.in.lists;

import java.util.UUID;

import com.chris.project.memories.love.domain.models.ListEnum;

public interface CreateListEnumUseCase {
      ListEnum execute(UUID customListUUID, ListEnum listEnum);
}
