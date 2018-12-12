package com.example.andreza.harvardmuseums.model.dao;

import android.content.Context;

import com.example.andreza.harvardmuseums.model.Classification;
import com.example.andreza.harvardmuseums.model.ClassificationRecords;
import com.example.andreza.harvardmuseums.service.RetrofitService;
import com.example.andreza.harvardmuseums.service.ServiceListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClassificationDAO {
    public List<Classification> getClassifications (final ServiceListener listener){

        Call<ClassificationRecords> call = RetrofitService.getAPI().getClassifications();

        call.enqueue(new Callback<ClassificationRecords>() {
            @Override
            public void onResponse(Call<ClassificationRecords> call, Response<ClassificationRecords> response) {
                if (response.body() != null){
                    listener.onSucess(response.body().getClassificationRecords());
                }
            }

            @Override
            public void onFailure(Call<ClassificationRecords> call, Throwable t) {
                listener.onError(t);
            }
        });

        return new ArrayList<>();
    }
}
