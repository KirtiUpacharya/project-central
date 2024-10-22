package com.example.Search_service.service;

import static org.mockito.Mockito.*;

import com.example.Search_service.Repository.SearchRepository;
import com.example.Search_service.Service.SearchService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SearchServiceTest {

    @Mock
    private SearchRepository searchRepository;

    @InjectMocks
    private SearchService searchService;

    @Test
    public void testSearch() {
        PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.ASC, "relevance"));
        searchService.search("test query", 0, 10, "relevance", true);

        verify(searchRepository, times(1)).findByQueryContainingIgnoreCase("test query", pageRequest);
    }
}

