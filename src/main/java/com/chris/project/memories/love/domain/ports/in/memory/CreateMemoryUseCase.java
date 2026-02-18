package com.chris.project.memories.love.domain.ports.in.memory;

import com.chris.project.memories.love.domain.models.Memory;

public interface CreateMemoryUseCase {
      Memory execute(Memory memory, String userCreator, byte[] imageContent, String filename);
}
