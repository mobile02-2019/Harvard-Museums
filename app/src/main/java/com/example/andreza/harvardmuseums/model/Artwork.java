package com.example.andreza.harvardmuseums.model;

import android.widget.ImageView;

import java.io.Serializable;

public class Artwork implements Serializable {

    private String title;
    private ImageView picture;

    public ImageView getPicture() {
        return picture;
    }

    public void setPicture(ImageView picture) {
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
