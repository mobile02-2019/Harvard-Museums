package com.example.andreza.harvardmuseums.model;

import com.example.andreza.harvardmuseums.pojo.Artwork;

import java.util.List;

public class ArtworkResponse {
    private List<Artwork> records;

    public List<Artwork> getRecords() {
        return records;
    }

    public void setRecords(List<Artwork> records) {
        this.records = records;
    }
}
