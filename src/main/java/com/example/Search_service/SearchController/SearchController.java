package com.example.Search_service.SearchController;

import com.example.Search_service.DTO.SearchResponse;
import com.example.Search_service.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @Autowired
    private RecommendationService recommendationService;

    @Autowired
    private UserService userService;

    @Autowired
    private AdsService adsService;

    @Autowired
    private CacheService cacheService;

    @GetMapping
    public SearchResponse search(
            @RequestParam String query,
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "asc") boolean asc,
            @RequestParam(defaultValue = "relevance") String sortField,
            @RequestHeader("User-ID") String userId
    ) {
        // Caching
        String cacheKey = "search:" + query + ":" + page + ":" + size + ":" + asc + ":" + sortField;
        SearchResponse cachedResponse = (SearchResponse) cacheService.getCachedResult(cacheKey);

        if (cachedResponse != null) {
            return cachedResponse;
        }

        // Perform search
        var searchResults = searchService.search(query, page, size, sortField, asc);

        // Get related recommendations
        var recommendations = recommendationService.getRecommendations(query);

        // Record user search history
        userService.recordSearchHistory(userId, query);

        // Fetch relevant ads
        var ads = adsService.getAds(query);

        // Build response
        SearchResponse response = new SearchResponse(searchResults, recommendations, ads);

        // Cache the response
        cacheService.cacheResult(cacheKey, response);

        return response;
    }
}

