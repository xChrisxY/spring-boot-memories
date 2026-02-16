package com.chris.project.memories.love.domain.ports.on.memory;

import com.chris.project.memories.love.domain.models.Memory;

public interface MemoryRepositoryPort {
      Memory save(Memory memory);
}
