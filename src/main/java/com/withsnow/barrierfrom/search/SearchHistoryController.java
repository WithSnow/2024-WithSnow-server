package com.withsnow.barrierfrom.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search-history")
public class SearchHistoryController {

    @Autowired
    private SearchHistoryRepository searchHistoryRepository;

    @GetMapping("/{userId}")
    public ResponseEntity<List<SearchHistory>> getSearchHistoryByUserId(@PathVariable Long userId) {
        List<SearchHistory> searchHistoryList = searchHistoryRepository.findByUser_UserId(userId);
        return ResponseEntity.ok(searchHistoryList);
    }
}
