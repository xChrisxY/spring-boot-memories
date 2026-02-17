package com.chris.project.memories.love.infrastructure.repositories.adapters;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chris.project.memories.love.domain.exceptions.RoleNotFoundException;
import com.chris.project.memories.love.domain.models.Role;
import com.chris.project.memories.love.domain.ports.on.role.RoleRepositoryPort;
import com.chris.project.memories.love.infrastructure.entities.RoleEntity;
import com.chris.project.memories.love.infrastructure.mappers.role.RolePersistenceMapper;
import com.chris.project.memories.love.infrastructure.repositories.JpaRoleRepository;

@Repository
public class JpaRoleRepositoryAdapter implements RoleRepositoryPort{

      private final JpaRoleRepository roleRepository;
      private final RolePersistenceMapper roleMapper;

      public JpaRoleRepositoryAdapter(JpaRoleRepository roleRepository, RolePersistenceMapper roleMapper){
            this.roleRepository = roleRepository;
            this.roleMapper = roleMapper;
      }

      @Override
      @Transactional(readOnly = true)
      public Role getRoleByName(String name){

            Optional<RoleEntity> optionalRole = roleRepository.findByName(name);

            if (optionalRole.isEmpty()){
                  throw new RoleNotFoundException(
                        String.format("Role con el nombre %s no fue encontrado", name)
                  );
            }

            RoleEntity roleEntity = optionalRole.get();
            return roleMapper.toDomain(roleEntity);
      }
}
