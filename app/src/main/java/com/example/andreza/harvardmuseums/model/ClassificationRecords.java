package com.example.andreza.harvardmuseums.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

//checar se nao seriauma lista de classificacao - novo pojo
public class ClassificationRecords {

    private List<Classification> records;

    public List<Classification> getClassificationRecords() {
        return records;
    }

    public void setRecords(List<Classification> records) {
        this.records = records;
    }
}
