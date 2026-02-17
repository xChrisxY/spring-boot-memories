package com.chris.project.memories.love.domain.models;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class User {

      private UUID id;
      private String username;
      private String passwordHash;
      private String email;
      private Set<Role> roles;

      public User(){
            this.roles = new HashSet<>();
      }

      public void addRole(Role role){
            this.roles.add(role);
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

      public Set<Role> getRoles() {
            return roles;
      }

      public void setRoles(Set<Role> roles) {
            this.roles = roles;
      }

}
