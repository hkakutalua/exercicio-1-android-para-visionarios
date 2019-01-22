package com.buka.exercicio1.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Artist {
    private String name;
    private int listeners;
    private String url;

    @SerializedName("image")
    private ArrayList<ArtistImage> images;

    public Artist(String name, int listeners, String url, ArrayList<ArtistImage> images) {
        this.name = name;
        this.listeners = listeners;
        this.url = url;
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public int getListeners() {
        return listeners;
    }

    public String getUrl() {
        return url;
    }

    public ArrayList<ArtistImage> getImages() {
        return images;
    }
}
