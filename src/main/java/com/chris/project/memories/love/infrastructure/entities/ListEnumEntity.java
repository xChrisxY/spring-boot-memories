package com.chris.project.memories.love.infrastructure.entities;

import java.util.UUID;

import com.chris.project.memories.love.domain.enums.ItemStatus;
import com.chris.project.memories.love.domain.models.CustomList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "list_items")
public class ListEnumEntity {

      @Id
      @GeneratedValue(strategy = GenerationType.UUID)
      private UUID id;

      @Column(nullable = false)
      private String content;

      @Enumerated(EnumType.STRING)
      private ItemStatus status;

      @ManyToOne
      @JoinColumn(name = "list_id", nullable = false)
      private CustomListEntity list;

      public UUID getId() {
            return id;
      }

      public void setId(UUID id) {
            this.id = id;
      }

      public String getContent() {
            return content;
      }

      public void setContent(String content) {
            this.content = content;
      }

      public ItemStatus getStatus() {
            return status;
      }

      public void setStatus(ItemStatus status) {
            this.status = status;
      }

      public CustomListEntity getList() {
            return list;
      }

      public void setList(CustomListEntity list) {
            this.list = list;
      }

}
