package com.example.andreza.harvardmuseums.fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.example.andreza.harvardmuseums.interfaces.ExhibitionListener;
import com.example.andreza.harvardmuseums.interfaces.RecyclerListenerExhibiton;
import com.example.andreza.harvardmuseums.pojo.Exhibition;
import com.example.andreza.harvardmuseums.model.ExhibitionResponse;
import com.example.andreza.harvardmuseums.model.dao.ExhibitionDAO;
import com.example.andreza.harvardmuseums.service.ServiceListener;

import java.util.ArrayList;
import java.util.List;

public class ExhibitionFragment extends Fragment implements ServiceListener,RecyclerListenerExhibiton {


    private ExhibitionListener listener;
    private RecyclerViewExhibitionAdapter adapter;
    private RecyclerView recyclerView;
    private List<Exhibition> exhibitionList = new ArrayList<>();
    private int page = 1;
    private final int PAGE_SIZE = 20;
    final ExhibitionDAO dao = new ExhibitionDAO();

    public ExhibitionFragment(){

    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        listener = (ExhibitionListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
//        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        View view = inflater.inflate(R.layout.fragment_exhibition,container,false);
        setUpRecyclerView(view);


        return view;


    }

    private void setUpRecyclerView(View view){
        recyclerView = view.findViewById(R.id.recyclerview_exhibition_id);
        adapter = new RecyclerViewExhibitionAdapter( new ArrayList<Exhibition>(),this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager( new LinearLayoutManager(getContext()));

        dao.getExhibitionList(getContext(),this,PAGE_SIZE,page);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (!recyclerView.canScrollVertically(1)) {

                    // Aumentar o offset (quantidade de itens que são "pulados" na busca paginada
                    // O offset sempre aumenta de acordo com a constante POST_LIMIT definida no dao
                    page = page +1 ;

                    // Chamar o método que busca Posts de forma paginada, porém com o novo offset
                    dao.getExhibitionList(getContext(),ExhibitionFragment.this,page,PAGE_SIZE);
                }
            }
        });
    }



    @Override
    public void onSucess(Object object) {
        ExhibitionResponse exhibitionResponse = (ExhibitionResponse) object;
        exhibitionList = exhibitionResponse.getRecords();

        //TODO:  isso que é um teste
//        for(Exhibition e: exhibitionList) {
//            e.setDescription("");
//        }
        //Fim apaga

        adapter.addExhibitionList(exhibitionList);


    }

    @Override
    public void onError(Throwable throwable) {
        Snackbar.make(recyclerView,throwable.getMessage(),Snackbar.LENGTH_LONG).show();

    }

    @Override
    public void onExhibitionClicado(Exhibition exhibition) {
        listener.iniciarExhibitionDetail(exhibition);

    }



}








