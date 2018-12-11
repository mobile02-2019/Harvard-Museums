package com.example.andreza.harvardmuseums.model;

import android.content.Intent;

import com.google.gson.annotations.SerializedName;

public class Classification {

    @SerializedName("name")
    private String classificationName;
    @SerializedName("id")
    private Integer classificationId;

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }

    public Integer getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Integer classificationId) {
        this.classificationId = classificationId;
    }
}
