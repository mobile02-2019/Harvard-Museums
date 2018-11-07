package com.example.andreza.harvardmuseums.pojo;

import com.google.gson.annotations.SerializedName;

public class ImageExhibition {
    @SerializedName("baseimageurl")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
