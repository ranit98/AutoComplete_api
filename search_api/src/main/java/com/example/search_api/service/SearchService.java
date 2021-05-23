package com.example.search_api.service;

import java.util.ArrayList;
import java.util.List;

import com.example.search_api.entity.LocationEntity;
import com.example.search_api.entity.MenuEntity;
import com.example.search_api.entity.RestaurantEntity;
import com.example.search_api.repository.LocationRepository;
import com.example.search_api.repository.MenuRepository;
import com.example.search_api.repository.RestaurantRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class SearchService{

  @Autowired
  private RestaurantRepository restaurantRepository;

  @Autowired
  private MenuRepository menuRepository;

  @Autowired
  private LocationRepository locationRepository;

  public List<String> findRestaurant(String searchString){
    List<String> restaurants = new ArrayList<String>();

    if(searchString.isEmpty())
      return restaurants;

    List<RestaurantEntity> allRestaurants = restaurantRepository.findAll();
    
    //exact search
    for(RestaurantEntity restaurantEntity : allRestaurants){
      if(searchString.equals(restaurantEntity.getRestaurant())){
        restaurants.add(restaurantEntity.getRestaurant());
      }
    }

    //partial search
    for(RestaurantEntity restaurantEntity : allRestaurants){
      if(restaurantEntity.getRestaurant().contains(searchString)){
        //checking if it is already in search result
        if(!restaurants.contains(restaurantEntity.getRestaurant())){
          restaurants.add(restaurantEntity.getRestaurant());
        }
      }
    }

    return restaurants;
  }

  public List<String> findLocation(String searchString){
    List<String> locations = new ArrayList<String>();

    if(searchString.isEmpty())
      return locations;

    List<LocationEntity> allLocations = locationRepository.findAll();
    
    //exact search
    for(LocationEntity locationEntity : allLocations){
      if(searchString.equals(locationEntity.getLocation())){
        locations.add(locationEntity.getLocation());
      }
    }

    //partial search
    for(LocationEntity locationEntity : allLocations){
      if(locationEntity.getLocation().contains(searchString)){
        //checking if it is already in search result
        if(!locations.contains(locationEntity.getLocation())){
          locations.add(locationEntity.getLocation());
        }
      }
    }

    return locations;
  }

  public List<String> findMenu(String searchString){
    List<String> menus = new ArrayList<String>();

    if(searchString.isEmpty())
      return menus;

    List<MenuEntity> allMenus = menuRepository.findAll();
    
    //exact search
    for(MenuEntity menuEntity : allMenus){
      if(searchString.equals(menuEntity.getMenu())){
        menus.add(menuEntity.getMenu());
      }
    }

    //partial search
    for(MenuEntity menuEntity : allMenus){
      if(menuEntity.getMenu().contains(searchString)){
        //checking if it is already in search result
        if(!menus.contains(menuEntity.getMenu())){
          menus.add(menuEntity.getMenu());
        }
      }
    }

    return menus;
  }
}
