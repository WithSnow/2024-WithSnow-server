package com.withsnow.barrierfrom.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search-history")
public class SearchHistoryController {

    @Autowired
    private SearchHistoryRepository searchHistoryRepository;

    @GetMapping
    public ResponseEntity<List<SearchHistory>> getSearchHistory() {
        List<SearchHistory> searchHistoryList = searchHistoryRepository.findAll();
        return ResponseEntity.ok(searchHistoryList);
    }
}
