package com.example.andreza.harvardmuseums.service;

import com.example.andreza.harvardmuseums.model.ClassificationRecords;
import com.example.andreza.harvardmuseums.model.ExhibitionResponse;
import com.example.andreza.harvardmuseums.model.ArtworkResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    @GET("/exhibition"+"?apikey=8b3bae80-bb8c-11e8-888b-13edf83f81a3&sort=chronological&sortorder=desc")
    Call<ExhibitionResponse> getExhibition();

    @GET("/object"+"?apikey=8b3bae80-bb8c-11e8-888b-13edf83f81a3&hasimage=1")
    Call<ArtworkResponse> getArtworks();

    @GET("/classification?apikey=5a360cc0-c8a9-11e8-a4b2-3df16a7b0d3c&size=999")
    Call<ClassificationRecords> getClassifications();

}
