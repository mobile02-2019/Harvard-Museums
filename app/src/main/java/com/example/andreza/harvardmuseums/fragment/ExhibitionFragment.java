package com.example.andreza.harvardmuseums.fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andreza.harvardmuseums.R;
import com.example.andreza.harvardmuseums.adapter.RecyclerViewExhibitionAdapter;
import com.example.andreza.harvardmuseums.pojo.Exhibition;
import com.example.andreza.harvardmuseums.model.ExhibitionResponse;
import com.example.andreza.harvardmuseums.model.dao.ExhibitionDAO;
import com.example.andreza.harvardmuseums.service.ServiceListener;

import java.util.ArrayList;
import java.util.List;

public class ExhibitionFragment extends Fragment implements ServiceListener {


    private Listener listener;
    private RecyclerViewExhibitionAdapter adapter;
    private RecyclerView recyclerView;
    private List<Exhibition> exhibitionList = new ArrayList<>();

    public interface Listener{
        void goToExhibitionDetail();

    }

    public ExhibitionFragment(){

    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        listener = (Listener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        View view = inflater.inflate(R.layout.fragment_exhibition,container,false);
        setUpRecyclerView(view);
        return view;


    }

    private void setUpRecyclerView(View view){
        recyclerView = view.findViewById(R.id.recyclerview_exhibition_id);
        ExhibitionDAO dao = new ExhibitionDAO();
        adapter = new RecyclerViewExhibitionAdapter(dao.getExhibitionList(getContext(),this),listener);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager( new LinearLayoutManager(getContext()));


    }


    @Override
    public void onSucess(Object object) {
        ExhibitionResponse exhibitionResponse = (ExhibitionResponse) object;
        exhibitionList = exhibitionResponse.getRecords();
        adapter.setExhibitionList(exhibitionList);


    }

    @Override
    public void onError(Throwable throwable) {
        Snackbar.make(recyclerView,throwable.getMessage(),Snackbar.LENGTH_LONG).show();

    }

    }








