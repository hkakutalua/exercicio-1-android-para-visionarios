package com.buka.exercicio1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.buka.exercicio1.api.LastFmApi;
import com.buka.exercicio1.models.Artist;
import com.buka.exercicio1.models.LastFmApiResponse;

import java.io.IOException;
import java.util.ArrayList;

public class ArtistsResultsActivity extends AppCompatActivity {

    public static final String EXTRA_SEARCH_TEXT = "extra_search_text";
    private static final String API_KEY = "d38510e4d32d8fe7d8bb7e060f460be5";

    private ProgressBar loadingProgressBar;
    private LastFmApi lastFmApi;
    private ArtistsResultsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists_results);

        RecyclerView searchResultsRecyclerView = findViewById(R.id.recyclerview_searchresults);
        loadingProgressBar = findViewById(R.id.progressbar_loading);

        adapter = new ArtistsResultsAdapter();
        searchResultsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchResultsRecyclerView.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ws.audioscrobbler.com/2.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        lastFmApi = retrofit.create(LastFmApi.class);

        Intent intent = getIntent();
        String searchTerms = intent.getStringExtra(EXTRA_SEARCH_TEXT);

        SearchArtistAsyncTask searchArtistAsyncTask = new SearchArtistAsyncTask();
        searchArtistAsyncTask.execute(searchTerms);
    }

    class SearchArtistAsyncTask extends AsyncTask<String, Void, ArrayList<Artist>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loadingProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected ArrayList<Artist> doInBackground(String... searchTerm) {
            try {
                Response<LastFmApiResponse> response = lastFmApi.searchArtist(searchTerm[0], API_KEY).execute();
                if (response.isSuccessful()) {
                    ArrayList<Artist> artistsFound = response.body()
                            .getSearchResults().getArtistsFound();
                    return artistsFound;
                } else {
                    Log.e(ArtistsResultsActivity.class.getSimpleName(), response.message());
                    return null;
                }
            } catch (IOException e) {
                Log.e(ArtistsResultsActivity.class.getSimpleName(), e.getMessage());
                return null;
            }
        }

        @Override
        protected void onPostExecute(ArrayList<Artist> artists) {
            super.onPostExecute(artists);

            loadingProgressBar.setVisibility(View.INVISIBLE);

            adapter.setArtists(artists);
        }
    }
}
