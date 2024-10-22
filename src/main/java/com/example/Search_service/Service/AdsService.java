package com.example.Search_service.Service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class AdsService {

    public List<String> getAds(String query) {
        // Simulating ads returned based on the search query
        List<String> ads = new ArrayList<>();

        if (query.toLowerCase().contains("car")) {
            ads.add("Car Sale - 20% Off");
            ads.add("Latest Car Models in 2024");
        } else if (query.toLowerCase().contains("phone")) {
            ads.add("Get the Latest Smartphone Now");
            ads.add("Special Discount on Mobile Phones");
        } else {
            ads.add("Check out our new products");
            ads.add("Exclusive deals for you");
        }

        return ads;
    }
}

