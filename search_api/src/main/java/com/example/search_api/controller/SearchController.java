package com.example.search_api.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.search_api.service.SearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(SearchController.APP_API_ENDPOINT)
public class SearchController {

  public static final String APP_API_ENDPOINT = "/app";
  public static final String SEARCH_API = "/search";
  
  @Autowired
  private SearchService searchService;

  @GetMapping(SEARCH_API)
  public ResponseEntity<List<String>> getSearchResults(String searchString){
    List<String> searchResults = new ArrayList<String>();

    for(String result : searchService.findRestaurant(searchString)){
      searchResults.add(result);
    }

    for(String result : searchService.findLocation(searchString)){
      searchResults.add(result);
    }

    for(String result : searchService.findMenu(searchString)){
      searchResults.add(result);
    }

    return ResponseEntity.ok().body(searchResults);
  }

}
