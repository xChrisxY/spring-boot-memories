package com.chris.project.memories.love.infrastructure.entities;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.chris.project.memories.love.domain.enums.UserRole;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "users")
public class UserEntity {

      @Id
      @GeneratedValue(strategy = GenerationType.UUID)
      private UUID id;

      @Column(nullable = false)
      private String username;

      @Column(name = "password_hash")
      private String passwordHash;

      @Column(unique = true)
      private String email;

      @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
      @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"), 
            inverseJoinColumns = @JoinColumn(name = "role_id"), 
            uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "role_id"})
      )
      private Set<RoleEntity> roles;

      public UserEntity(){
            this.roles = new HashSet<>();
      }

      public void addRole(RoleEntity roleEntity){
            this.roles.add(roleEntity);
      }

      public UUID getId() {
            return id;
      }

      public void setId(UUID id) {
            this.id = id;
      }

      public String getUsername() {
            return username;
      }

      public void setUsername(String username) {
            this.username = username;
      }

      public String getPasswordHash() {
            return passwordHash;
      }

      public void setPasswordHash(String passwordHash) {
            this.passwordHash = passwordHash;
      }

      public String getEmail() {
            return email;
      }

      public void setEmail(String email) {
            this.email = email;
      }

      public Set<RoleEntity> getRoles() {
            return roles;
      }

      public void setRoles(Set<RoleEntity> roles) {
            this.roles = roles;
      }
}
