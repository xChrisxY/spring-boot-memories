package com.chris.project.memories.love.domain.ports.in.user;

import com.chris.project.memories.love.domain.models.User;

public interface CreateUserUseCase {
      User execute(User user);
}