package com.buka.exercicio1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.buka.exercicio1.models.Artist;

import java.util.ArrayList;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ArtistsResultsAdapter extends RecyclerView.Adapter<ArtistsResultsAdapter.ArtistResultViewHolder> {
    private ArrayList<Artist> artists = new ArrayList<>();

    @NonNull
    @Override
    public ArtistResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View artistResultView = inflater.inflate(R.layout.item_artist_result, parent, false);
        return new ArtistResultViewHolder(artistResultView);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistResultViewHolder holder, int position) {
        Artist artist = artists.get(position);
        holder.nameTextView.setText(artist.getName());
        holder.listenersCountTextView.setText(
                String.format(Locale.getDefault(), "%d ouvintes(s)", artist.getListeners()));
        holder.artistImagesAdapter.setArtistImages(artist.getImages());
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    public void setArtists(ArrayList<Artist> artists) {
        if (artists != null) {
            this.artists = artists;
            notifyDataSetChanged();
        }
    }

    class ArtistResultViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView listenersCountTextView;
        ArtistImagesAdapter artistImagesAdapter;

        ArtistResultViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.textview_name);
            listenersCountTextView = itemView.findViewById(R.id.textview_listenerscount);

            artistImagesAdapter = new ArtistImagesAdapter();

            RecyclerView artistImagesRecyclerView = itemView.findViewById(R.id.recyclerview_images);
            artistImagesRecyclerView.setAdapter(artistImagesAdapter);
            artistImagesRecyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext(), RecyclerView.HORIZONTAL, false));
        }
    }
}
