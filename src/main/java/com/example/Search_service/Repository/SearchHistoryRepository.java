package com.example.Search_service.Repository;


import com.example.Search_service.Model.SearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchHistoryRepository extends JpaRepository<SearchHistory, Long> {
    // Additional queries related to Search History if needed
}

