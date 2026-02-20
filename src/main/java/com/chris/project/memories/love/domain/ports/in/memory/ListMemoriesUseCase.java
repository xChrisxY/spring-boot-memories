package com.chris.project.memories.love.domain.ports.in.memory;

import java.util.List;

import com.chris.project.memories.love.domain.models.Memory;

public interface ListMemoriesUseCase {
      List<Memory> execute();
}
