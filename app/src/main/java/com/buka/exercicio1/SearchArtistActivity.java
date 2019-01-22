package com.buka.exercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SearchArtistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_artist);

        final TextInputLayout searchTextInputLayout = findViewById(R.id.textinputlayout_search);
        final TextInputEditText searchEditText = findViewById(R.id.edittext_search);
        Button searchButton = findViewById(R.id.button_search);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchTextInputLayout.setErrorEnabled(false);
                validateSearchText(searchEditText, searchTextInputLayout);

                Intent intent = new Intent(SearchArtistActivity.this, ArtistsResultsActivity.class);
                intent.putExtra(ArtistsResultsActivity.EXTRA_SEARCH_TEXT, searchEditText.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void validateSearchText(TextInputEditText searchEditText, TextInputLayout searchTextInputLayout) {
        String searchText = searchEditText.getText().toString();
        if (searchText.isEmpty()) {
            searchTextInputLayout.setErrorEnabled(true);
            searchTextInputLayout.setError(getString(R.string.artist_text_empty_error));
        }
    }
}
