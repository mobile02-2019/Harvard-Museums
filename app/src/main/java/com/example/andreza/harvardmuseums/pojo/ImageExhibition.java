package com.example.andreza.harvardmuseums.pojo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ImageExhibition implements Serializable {
    @SerializedName("baseimageurl")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
