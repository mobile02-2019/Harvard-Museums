package com.example.andreza.harvardmuseums.service;

import com.example.andreza.harvardmuseums.model.ExhibitionResponse;
import com.example.andreza.harvardmuseums.model.ArtworkResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    @GET("/exhibition"+"?apikey=8b3bae80-bb8c-11e8-888b-13edf83f81a3")
    Call<ExhibitionResponse> getExhibition();

    @GET("/object"+"?apikey=8b3bae80-bb8c-11e8-888b-13edf83f81a3")
    Call<ArtworkResponse> getArtworks();


}
