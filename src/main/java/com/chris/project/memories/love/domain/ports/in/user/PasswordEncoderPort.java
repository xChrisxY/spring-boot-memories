package com.chris.project.memories.love.domain.ports.in.user;

public interface PasswordEncoderPort {
      String encode(String rawPassword);
}
