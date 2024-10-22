package com.example.Search_service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResponse {

    private Object searchResults;
    private List<String> recommendations;
    private List<String> ads;
}

