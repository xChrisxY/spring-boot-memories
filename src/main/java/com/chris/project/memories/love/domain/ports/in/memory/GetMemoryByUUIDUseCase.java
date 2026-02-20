package com.chris.project.memories.love.domain.ports.in.memory;

import java.util.UUID;

import com.chris.project.memories.love.domain.models.Memory;

public interface GetMemoryByUUIDUseCase {
      Memory execute(UUID uuid);
}
