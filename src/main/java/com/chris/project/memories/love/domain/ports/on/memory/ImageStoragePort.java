package com.chris.project.memories.love.domain.ports.on.memory;

import com.chris.project.memories.love.domain.models.ImageUploadResult;

public interface ImageStoragePort {

      ImageUploadResult upload(byte[] content, String filename);

}
