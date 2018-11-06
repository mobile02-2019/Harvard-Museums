package com.example.andreza.harvardmuseums.model.dao;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.example.andreza.harvardmuseums.model.Exhibition;
import com.example.andreza.harvardmuseums.service.RetrofitService;
import com.example.andreza.harvardmuseums.service.ServiceListener;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExhibitionDAO {

    public List<Exhibition> getExhibitionList(Context context, final ServiceListener listener){
        List<Exhibition> exhibitionList = new ArrayList<>();

        Call<List<Exhibition>> call = RetrofitService.getAPI().getExhibibtions();

        call.enqueue(new Callback<List<Exhibition>>() {


            @Override
            public void onResponse(Call<List<Exhibition>> call, Response<List<Exhibition>> response) {
                if(response.body() != null){
                    listener.onSucess(response.body());
                }

            }

            @Override
            public void onFailure(Call<List<Exhibition>> call, Throwable t) {
                listener.onError(t);

            }
        });
        return exhibitionList;
    }

    private List<Exhibition> getLocalExhibition(Context context){
        try{
            AssetManager manager = context.getAssets();
            InputStream postJson = manager.open("exhibiitonJson");

            InputStreamReader inputStreamReader = new InputStreamReader(postJson);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            Gson gson = new Gson();

            Exhibition[] exhibitionArray = gson.fromJson(bufferedReader,Exhibition[].class);

            return Arrays.asList(exhibitionArray);

        }catch(IOException exception){
            Log.e("ExhibitionDAO","Erro ao ler arquivo");
        }
        return new ArrayList<>();
    }
}
