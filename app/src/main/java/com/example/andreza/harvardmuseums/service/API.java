package com.example.andreza.harvardmuseums.service;

import com.example.andreza.harvardmuseums.model.ExhibitionResponse;
import com.example.andreza.harvardmuseums.model.ArtworkResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

    @GET("/exhibition"+"?apikey=8b3bae80-bb8c-11e8-888b-13edf83f81a3&sort=chronological&sortorder=desc")
    Call<ExhibitionResponse> getExhibition();


    @GET("/exhibition"+"?apikey=8b3bae80-bb8c-11e8-888b-13edf83f81a3&sort=chronological&sortorder=desc")
    Call<ExhibitionResponse> getExhibitionPage(@Query("size") int size,
                                               @Query("page") int page);


    @GET("/object"+"?apikey=8b3bae80-bb8c-11e8-888b-13edf83f81a3")
    Call<ArtworkResponse> getArtworkPage(@Query("size") int size,
                                                @Query("page") int page);



}
