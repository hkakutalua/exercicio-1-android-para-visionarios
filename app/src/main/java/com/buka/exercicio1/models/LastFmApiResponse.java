package com.buka.exercicio1.models;

import com.google.gson.annotations.SerializedName;

public class LastFmApiResponse {
    @SerializedName("results")
    private SearchResults searchResults;

    public LastFmApiResponse(SearchResults searchResults) {
        this.searchResults = searchResults;
    }

    public SearchResults getSearchResults() {
        return searchResults;
    }
}