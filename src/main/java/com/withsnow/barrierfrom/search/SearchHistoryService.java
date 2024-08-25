package com.withsnow.barrierfrom.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SearchHistoryService {

    @Autowired
    private SearchHistoryRepository searchHistoryRepository;

    public void saveSearchHistory(String searchTerm, String searchType, Double latitude, Double longitude, Double searchRadius, Integer resultCount) {
        SearchHistory searchHistory = new SearchHistory();
        searchHistory.setSearchTerm(searchTerm);
        searchHistory.setSearchType(searchType);
        searchHistory.setLatitude(latitude);
        searchHistory.setLongitude(longitude);
        searchHistory.setSearchRadius(searchRadius);
        searchHistory.setResultCount(resultCount);
        searchHistory.setSearchedAt(LocalDateTime.now());

        searchHistoryRepository.save(searchHistory);
    }
}
