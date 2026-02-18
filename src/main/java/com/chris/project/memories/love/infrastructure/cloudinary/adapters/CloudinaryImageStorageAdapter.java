package com.chris.project.memories.love.infrastructure.cloudinary.adapters;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.chris.project.memories.love.domain.models.ImageUploadResult;
import com.chris.project.memories.love.domain.ports.on.memory.ImageStoragePort;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Component
public class CloudinaryImageStorageAdapter implements ImageStoragePort {

      private final Cloudinary cloudinary;

      public CloudinaryImageStorageAdapter(Cloudinary cloudinary){
            this.cloudinary = cloudinary;
      }

      @Override
      public ImageUploadResult upload(byte[] content, String filename){

            try {

                  Map<?, ?> result = cloudinary.uploader().upload(
                        content, 
                        ObjectUtils.asMap(
                              "folder", "memories", 
                              "public_id", filename
                        )
                  );

                  String url = result.get("secure_url").toString();
                  String publicId = result.get("public_id").toString();

                  return new ImageUploadResult(url, publicId);

            } catch (IOException e) {
                  throw new RuntimeException("Error uploading image", e);
            }
            
      }
}
