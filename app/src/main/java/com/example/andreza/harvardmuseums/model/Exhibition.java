package com.example.andreza.harvardmuseums.model;

import java.io.Serializable;

public class Exhibition implements Serializable {

    private String title;
    private String date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Exhibition(String title, String date) {
        this.title = title;
        this.date = date;
    }

}
