package com.buka.exercicio1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.buka.exercicio1.models.ArtistImage;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

public class ArtistImagesAdapter extends RecyclerView.Adapter<ArtistImagesAdapter.ArtistImageViewHolder> {
    private ArrayList<ArtistImage> artistImages = new ArrayList<>();

    @NonNull
    @Override
    public ArtistImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View artistImageRootView = inflater.inflate(R.layout.item_artist_image, parent, false);
        return new ArtistImageViewHolder(artistImageRootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistImageViewHolder holder, int position) {
        ArtistImage artistImage = artistImages.get(position);

        if (artistImage.getLink().isEmpty())
            return;

        Picasso.get().load(artistImage.getLink()).into(holder.photoImageView);
    }

    @Override
    public int getItemCount() {
        return artistImages.size();
    }

    public void setArtistImages(ArrayList<ArtistImage> artistImages) {
        if (artistImages != null) {
            this.artistImages = artistImages;
            notifyDataSetChanged();
        }
    }

    class ArtistImageViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView photoImageView;

        ArtistImageViewHolder(@NonNull View itemView) {
            super(itemView);
            photoImageView = itemView.findViewById(R.id.imageview_photo);
        }
    }
}
