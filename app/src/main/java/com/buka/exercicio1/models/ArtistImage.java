package com.buka.exercicio1.models;

import com.google.gson.annotations.SerializedName;

public class ArtistImage {
    @SerializedName("#text")
    private String link;
    private String size;

    public ArtistImage(String link, String size) {
        this.link = link;
        this.size = size;
    }

    public String getLink() {
        return link;
    }

    public String getSize() {
        return size;
    }
}
