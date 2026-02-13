package com.chris.project.memories.love.domain.ports.on;

import java.util.Optional;

import com.chris.project.memories.love.domain.models.User;

public interface UserRepositoryPort {
      User save(User user);
      Optional<User> getUserById(Long id);
}