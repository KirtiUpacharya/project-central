package com.example.Search_service.Repository;

import com.example.Search_service.Model.SearchResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchRepository extends JpaRepository<SearchResult, Long> {

    // Method to search by query and paginate results
    Page<SearchResult> findByQueryContainingIgnoreCase(String query, Pageable pageable);
}


