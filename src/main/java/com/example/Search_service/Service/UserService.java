package com.example.Search_service.Service;


import com.example.Search_service.Model.SearchHistory;
import com.example.Search_service.Model.User;
import com.example.Search_service.Repository.SearchHistoryRepository;
import com.example.Search_service.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SearchHistoryRepository searchHistoryRepository;

    public void recordSearchHistory(String userId, String query) {
        // Fetch user by ID
        Optional<User> userOptional = userRepository.findById(Long.valueOf(userId));

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // Create a new SearchHistory entry
            SearchHistory searchHistory = new SearchHistory();
            searchHistory.setUser(user);
            searchHistory.setQuery(query);
            searchHistory.setTimestamp(System.currentTimeMillis());

            // Save the search history for the user
            searchHistoryRepository.save(searchHistory);

        } else {
            // Handle the case where user is not found
            throw new RuntimeException("User not found with ID: " + userId);
        }
    }
}

