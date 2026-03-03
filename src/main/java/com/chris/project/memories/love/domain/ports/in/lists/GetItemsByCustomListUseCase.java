package com.chris.project.memories.love.domain.ports.in.lists;

import java.util.List;
import java.util.UUID;

import com.chris.project.memories.love.domain.models.ListEnum;

public interface GetItemsByCustomListUseCase {
      List<ListEnum> execute(UUID customListUUID);
}
