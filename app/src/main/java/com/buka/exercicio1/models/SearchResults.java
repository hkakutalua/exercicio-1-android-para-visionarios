package com.buka.exercicio1.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SearchResults {
    @SerializedName("opensearch:totalResults")
    private int totalResults;

    @SerializedName("opensearch:startIndex")
    private int startIndex;

    @SerializedName("opensearch:itemsPerPage")
    private int itemsPerPage;

    @SerializedName("artistmatches")
    private ArtistMatches artistMatches;

    public SearchResults(int totalResults, int startIndex, int itemsPerPage, ArtistMatches artistMatches) {
        this.totalResults = totalResults;
        this.startIndex = startIndex;
        this.itemsPerPage = itemsPerPage;
        this.artistMatches = artistMatches;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public ArrayList<Artist> getArtistsFound() {
        return artistMatches.getArtists();
    }

    private class ArtistMatches {
        @SerializedName("artist")
        private ArrayList<Artist> artists;

        public ArtistMatches(ArrayList<Artist> artists) {
            this.artists = artists;
        }

        public ArrayList<Artist> getArtists() {
            return artists;
        }
    }
}
