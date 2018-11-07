package com.example.andreza.harvardmuseums.service;

import com.example.andreza.harvardmuseums.model.Artwork;
import com.example.andreza.harvardmuseums.model.Exhibition;
import com.example.andreza.harvardmuseums.model.ExhibitionResponse;
import com.example.andreza.harvardmuseums.model.MuseumResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    @GET("/exhibition"+"?apikey=8b3bae80-bb8c-11e8-888b-13edf83f81a3")
    Call<ExhibitionResponse> getExhibition();

    @GET("/image"+"?apikey=8b3bae80-bb8c-11e8-888b-13edf83f81a3")
    Call<MuseumResponse> getArtworks();


}
