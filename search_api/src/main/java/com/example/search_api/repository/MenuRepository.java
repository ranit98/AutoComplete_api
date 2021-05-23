package com.example.search_api.repository;

import java.util.List;
import java.util.Optional;

import com.example.search_api.entity.MenuEntity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends MongoRepository<MenuEntity,String>{
  Optional<MenuEntity> findById(String id);
}
