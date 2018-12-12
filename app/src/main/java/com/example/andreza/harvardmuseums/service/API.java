package com.example.andreza.harvardmuseums.service;

import com.example.andreza.harvardmuseums.model.ClassificationRecords;
import com.example.andreza.harvardmuseums.model.ExhibitionResponse;
import com.example.andreza.harvardmuseums.model.ArtworkResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {


    @GET("/exhibition"+"?apikey=8b3bae80-bb8c-11e8-888b-13edf83f81a3&sort=chronological&sortorder=desc")
    Call<ExhibitionResponse> getExhibitionPage(@Query("size") int size,
                                               @Query("page") int page);


    @GET("/object"+"?apikey=8b3bae80-bb8c-11e8-888b-13edf83f81a3&hasimage=1")
    Call<ArtworkResponse> getArtworks();


    @GET("/object"+"?apikey=8b3bae80-bb8c-11e8-888b-13edf83f81a3")
    Call<ArtworkResponse> getArtworkPage(@Query("size") int size,
                                                @Query("page") int page);


    @GET("/classification?apikey=5a360cc0-c8a9-11e8-a4b2-3df16a7b0d3c&size=999")
    Call<ClassificationRecords> getClassifications();

}
