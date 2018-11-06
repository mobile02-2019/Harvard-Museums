package com.example.andreza.harvardmuseums.Service;

import com.example.andreza.harvardmuseums.model.Artwork;
import com.example.andreza.harvardmuseums.model.Exhibition;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    @GET("/posts")
    Call<List<Exhibition>> getExhibibtions();

    @GET("/posts")
    Call<List<Artwork>> getArtworks();


}
