package com.example.andreza.harvardmuseums.model.dao;

import android.content.Context;

import com.example.andreza.harvardmuseums.model.ArtworkResponse;
import com.example.andreza.harvardmuseums.service.RetrofitService;
import com.example.andreza.harvardmuseums.service.ServiceListener;
import com.example.andreza.harvardmuseums.pojo.Artwork;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtworkDAO {

    public List<Artwork> getArtList (Context context, final ServiceListener listener,int size,int page){

        Call<ArtworkResponse> call = RetrofitService.getAPI().getArtworkPage(size,page);

        call.enqueue(new Callback<ArtworkResponse>() {
            @Override
            public void onResponse(Call<ArtworkResponse> call, Response<ArtworkResponse> response) {
                if (response.body() != null){
                    listener.onSucess(response.body().getRecords());
                }
            }

            @Override
            public void onFailure(Call<ArtworkResponse> call, Throwable t) {
                    listener.onError(t);
            }
        });

        return new ArrayList<>();
    }


    public Artwork getArtDetailList (Context context, final ServiceListener listener,int size,int page){

        Call<ArtworkResponse> call = RetrofitService.getAPI().getArtworkPage(size,page);

        call.enqueue(new Callback<ArtworkResponse>() {
            @Override
            public void onResponse(Call<ArtworkResponse> call, Response<ArtworkResponse> response) {
                if (response.body() != null){
                    listener.onSucess(response.body().getRecords());
                }
            }

            @Override
            public void onFailure(Call<ArtworkResponse> call, Throwable t) {
                listener.onError(t);
            }
        });

        return new Artwork();
    }

}
