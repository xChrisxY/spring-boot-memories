package com.chris.project.memories.love.domain.ports.on.user;

import java.util.Optional;
import java.util.UUID;

import com.chris.project.memories.love.domain.models.User;

public interface UserRepositoryPort {
      User save(User user);
      Optional<User> getUserById(UUID uuid);
      Optional<User> findByUsername(String username);
}