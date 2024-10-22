package com.example.Search_service.Service;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecommendationService {

    // Mock recommendations
    public List<String> getRecommendations(String query) {
        return List.of("Suggested Search 1", "Suggested Search 2", "Suggested Search 3");
    }
}
