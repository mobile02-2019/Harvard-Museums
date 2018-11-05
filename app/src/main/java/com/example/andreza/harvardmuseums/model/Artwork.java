package com.example.andreza.harvardmuseums.model;

import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Artwork implements Serializable {

    @SerializedName("title")
    private String title;
    @SerializedName("imageUrl")
    private String picture; //Mudei aqui de ImageView para String para poder utilizar a URL

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
