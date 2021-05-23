package com.example.search_api.repository;

import java.util.List;
import java.util.Optional;

import com.example.search_api.entity.RestaurantEntity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends MongoRepository<RestaurantEntity,String>{
  Optional<RestaurantEntity> findById(String id);;
}
