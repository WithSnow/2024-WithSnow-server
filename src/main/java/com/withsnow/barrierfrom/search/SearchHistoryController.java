package com.withsnow.barrierfrom.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search-history")
public class SearchHistoryController {

    @Autowired
    private SearchHistoryRepository searchHistoryRepository;

    @GetMapping //검색기록 조회하기
    public ResponseEntity<List<SearchHistory>> getSearchHistory() {
        List<SearchHistory> searchHistoryList = searchHistoryRepository.findAll();
        return ResponseEntity.ok(searchHistoryList);
    }

    // 검색 기록 단일 삭제하기
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSearchHistory(@PathVariable Long id) {
        if (searchHistoryRepository.existsById(id)) {
            searchHistoryRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // 성공적으로 삭제했음을 반환
        } else {
            return ResponseEntity.notFound().build(); // 삭제할 기록이 없음을 반환
        }
    }

    // 검색 기록 전체 삭제하기
    @DeleteMapping
    public ResponseEntity<Void> deleteAllSearchHistory() {
        searchHistoryRepository.deleteAll();
        return ResponseEntity.noContent().build(); // 성공적으로 전체 삭제했음을 반환
    }
}
