package com.chris.project.memories.love.domain.ports.on.role;

import com.chris.project.memories.love.domain.models.Role;

public interface RoleRepositoryPort {
      Role getRoleByName(String name);
}
