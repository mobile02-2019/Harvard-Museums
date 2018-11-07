package com.example.andreza.harvardmuseums.model;

import android.widget.ListView;

import java.util.List;

public class ExhibitionResponse {
    private List<Exhibition> records;

    public List<Exhibition> getRecords() {
        return records;
    }

    public void setRecords(List<Exhibition> records) {
        this.records = records;
    }
}
