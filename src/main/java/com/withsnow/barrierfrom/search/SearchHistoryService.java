package com.withsnow.barrierfrom.search;

import com.withsnow.barrierfrom.user.User;
import com.withsnow.barrierfrom.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SearchHistoryService {

    @Autowired
    private SearchHistoryRepository searchHistoryRepository;

    @Autowired
    private UserRepository userRepository;

    public void saveSearchHistory(User user, String searchTerm, String searchType, Double latitude, Double longitude, Double searchRadius, Integer resultCount) {
        user = userRepository.findById(user.getUserId()).orElse(null);
        
        SearchHistory searchHistory = new SearchHistory();
        searchHistory.setUser(user);  // User 객체 설정
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
