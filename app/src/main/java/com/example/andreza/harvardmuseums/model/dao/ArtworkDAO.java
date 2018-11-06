package com.example.andreza.harvardmuseums.model.dao;

import android.content.Context;

import com.example.andreza.harvardmuseums.Service.RetrofitService;
import com.example.andreza.harvardmuseums.Service.ServiceListener;
import com.example.andreza.harvardmuseums.model.Artwork;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ArtworkDAO {

    public List<Artwork> getArtList (Context context, final ServiceListener listener){

        Call<List<Artwork>> call = RetrofitService.getPostApi().getArtworks();

        call.enqueue(new Callback<List<Artwork>>() {
            @Override
            public void onResponse(Call<List<Artwork>> call, Response<List<Artwork>> response) {
                if (response.body() != null){
                    listener.onSucess(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Artwork>> call, Throwable t) {
                    listener.onError(t);
            }
        });

        return new ArrayList<>();
    }

}
