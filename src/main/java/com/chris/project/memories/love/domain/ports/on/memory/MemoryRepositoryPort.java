package com.chris.project.memories.love.domain.ports.on.memory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.chris.project.memories.love.domain.models.Memory;

public interface MemoryRepositoryPort {
      Memory save(Memory memory);
      Optional<Memory> findByUUID(UUID uuid);
      List<Memory> findAll();
}
