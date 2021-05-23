package com.example.search_api.repository;

import java.util.List;
import java.util.Optional;

import com.example.search_api.entity.LocationEntity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends MongoRepository<LocationEntity, String>{
  Optional<LocationEntity> findById(String id);
}

