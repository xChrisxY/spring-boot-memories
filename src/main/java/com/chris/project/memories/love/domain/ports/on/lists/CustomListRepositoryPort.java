package com.chris.project.memories.love.domain.ports.on.lists;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.chris.project.memories.love.domain.models.CustomList;
import com.chris.project.memories.love.domain.models.ListEnum;

public interface CustomListRepositoryPort {
      CustomList save(CustomList customList);
      Optional<CustomList> findById(UUID id);
      List<ListEnum> getListEnumByCustomListUUID(UUID uuid);
}
