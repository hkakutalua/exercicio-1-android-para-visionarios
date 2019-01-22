package com.buka.exercicio1.api;

import com.buka.exercicio1.models.LastFmApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface LastFmApi {
    @GET("?method=artist.search&format=json")
    Call<LastFmApiResponse> searchArtist(@Query("artist") String searchTerms, @Query("api_key") String apiKey);
}
