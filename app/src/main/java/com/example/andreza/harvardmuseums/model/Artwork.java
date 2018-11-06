package com.example.andreza.harvardmuseums.model;

import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Artwork implements Serializable {

    @SerializedName("copyright")
    private String title;
    @SerializedName("baseimageurl")
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
