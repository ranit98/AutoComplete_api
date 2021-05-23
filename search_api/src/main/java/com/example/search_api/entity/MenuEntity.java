package com.example.search_api.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Document(collection = "restaurants")
@NoArgsConstructor
@AllArgsConstructor
public class MenuEntity {
  @Id
  private String id;

  private String menu;

  private String restaurant_id;

}
