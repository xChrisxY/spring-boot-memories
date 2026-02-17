package com.chris.project.memories.love.infrastructure.repositories.adapters;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chris.project.memories.love.domain.exceptions.RoleNotFoundException;
import com.chris.project.memories.love.domain.models.Role;
import com.chris.project.memories.love.domain.models.User;
import com.chris.project.memories.love.domain.ports.on.user.UserRepositoryPort;
import com.chris.project.memories.love.infrastructure.entities.RoleEntity;
import com.chris.project.memories.love.infrastructure.entities.UserEntity;
import com.chris.project.memories.love.infrastructure.mappers.user.UserPersistenceMapper;
import com.chris.project.memories.love.infrastructure.repositories.JpaRoleRepository;
import com.chris.project.memories.love.infrastructure.repositories.JpaUserRepository;

@Repository
public class JpaUserRepositoryAdapter implements UserRepositoryPort{

      private final JpaUserRepository userRepository;
      private final JpaRoleRepository roleRepository;
      private final UserPersistenceMapper userMapper;
      
      public JpaUserRepositoryAdapter(
            JpaUserRepository userRepository,
            JpaRoleRepository roleRepository,
            UserPersistenceMapper userMapper
      ){
            this.userRepository = userRepository;
            this.roleRepository = roleRepository;
            this.userMapper = userMapper;
      }

      @Override
      @Transactional
      public User save(User user){

            UserEntity entity = userMapper.toEntity(user);
            
            Set<Role> roles = user.getRoles();

            roles.forEach(role -> {
                  RoleEntity roleEntity = roleRepository.findByName(role.getName())
                        .orElseThrow(() -> new RoleNotFoundException("Role not found: " + role.getName()));

                  entity.addRole(roleEntity);
            });

            UserEntity savedEntity = userRepository.save(entity);
            return userMapper.toDomain(savedEntity);
      }

      @Override
      @Transactional
      public Optional<User> getUserById(Long user){
            return null;
      }

}
