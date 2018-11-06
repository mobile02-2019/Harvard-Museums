package com.example.andreza.harvardmuseums.model.dao;

import android.content.Context;

import com.example.andreza.harvardmuseums.model.MuseumResponse;
import com.example.andreza.harvardmuseums.service.RetrofitService;
import com.example.andreza.harvardmuseums.service.ServiceListener;
import com.example.andreza.harvardmuseums.model.Artwork;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtworkDAO {

    public List<Artwork> getArtList (Context context, final ServiceListener listener){

        Call<MuseumResponse> call = RetrofitService.getAPI().getArtworks();

        call.enqueue(new Callback<MuseumResponse>() {
            @Override
            public void onResponse(Call<MuseumResponse> call, Response<MuseumResponse> response) {
                if (response.body() != null){
                    listener.onSucess(response.body().getRecords());
                }
            }

            @Override
            public void onFailure(Call<MuseumResponse> call, Throwable t) {
                    listener.onError(t);
            }
        });

        return new ArrayList<>();
    }

}
