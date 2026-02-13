package com.chris.project.memories.love.infrastructure.repositories.adapters;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chris.project.memories.love.domain.models.User;
import com.chris.project.memories.love.domain.ports.on.UserRepositoryPort;
import com.chris.project.memories.love.infrastructure.entities.UserEntity;
import com.chris.project.memories.love.infrastructure.mappers.user.UserPersistenceMapper;
import com.chris.project.memories.love.infrastructure.repositories.JpaUserRepository;

@Repository
public class JpaUserRepositoryAdapter implements UserRepositoryPort{

      private final JpaUserRepository userRepository;
      private final UserPersistenceMapper userMapper;
      
      public JpaUserRepositoryAdapter(JpaUserRepository userRepository, UserPersistenceMapper userMapper){
            this.userRepository = userRepository;
            this.userMapper = userMapper;
      }

      @Override
      @Transactional
      public User save(User user){
            UserEntity entity = userMapper.toEntity(user);
            UserEntity savedEntity = userRepository.save(entity);
            return userMapper.toDomain(savedEntity);
      }

      @Override
      @Transactional
      public Optional<User> getUserById(Long user){
            return null;
      }

}
