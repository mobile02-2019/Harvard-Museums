package com.example.andreza.harvardmuseums.model;

import com.example.andreza.harvardmuseums.pojo.Exhibition;

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
