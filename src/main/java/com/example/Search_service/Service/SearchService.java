package com.example.Search_service.Service;



import com.example.Search_service.Model.SearchResult;
import com.example.Search_service.Repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Service
public class SearchService {

    @Autowired
    private SearchRepository searchRepository;

    public Page<SearchResult> search(String query, int page, int size, String sortField, boolean asc) {
        Sort.Direction sortDirection = asc ? Sort.Direction.ASC : Sort.Direction.DESC;
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(sortDirection, sortField));

        return searchRepository.findByQueryContainingIgnoreCase(query, pageRequest);
    }
}
