package com.example.andreza.harvardmuseums.model;

import java.io.Serializable;

public class Artwork implements Serializable {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
