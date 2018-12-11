package com.example.andreza.harvardmuseums.model.dao;

import android.content.Context;

import com.example.andreza.harvardmuseums.pojo.Exhibition;
import com.example.andreza.harvardmuseums.model.ExhibitionResponse;
import com.example.andreza.harvardmuseums.service.RetrofitService;
import com.example.andreza.harvardmuseums.service.ServiceListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExhibitionDAO {

    
    public void getExhibitionList(Context context, final ServiceListener listener,int size,int page){


        Call<ExhibitionResponse> call = RetrofitService.getAPI().getExhibitionPage(size,page);

        call.enqueue(new Callback<ExhibitionResponse>() {

            @Override
            public void onResponse(Call<ExhibitionResponse> call, Response <ExhibitionResponse> response) {
                if(response.body() != null){
                    listener.onSucess(response.body());
                }

            }

            @Override
            public void onFailure(Call<ExhibitionResponse> call, Throwable t) {
                listener.onError(t);

            }
        });
    }
/*todo:
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
    }*/
}
