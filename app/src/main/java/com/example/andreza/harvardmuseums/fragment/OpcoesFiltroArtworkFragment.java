package com.example.andreza.harvardmuseums.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.andreza.harvardmuseums.R;
import com.example.andreza.harvardmuseums.adapter.RecyclerViewFiltroArtworkAdapter;
import com.example.andreza.harvardmuseums.model.Classification;
import com.example.andreza.harvardmuseums.model.dao.ClassificationDAO;
import com.example.andreza.harvardmuseums.service.ServiceListener;
import com.facebook.login.widget.LoginButton;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class OpcoesFiltroArtworkFragment extends Fragment implements ServiceListener {
    private RecyclerView recyclerView;
    private View view;
    private RecyclerViewFiltroArtworkAdapter adapter;


    public OpcoesFiltroArtworkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_opcoes_filtro_artwork, container, false);

        Bundle bundle = getArguments();
        String title = bundle.getString("title");

        if (title.equals("Classification")) {
            createRecyclerClassification();
            final ClassificationDAO dao = new ClassificationDAO();
            dao.getClassifications(this);
        }

        if (title == "Gallery") {
            createRecyclerGallery();
        }

        if (title == "Culture") {
            createRecyclerCulture();
        }
        // Inflate the layout for this fragment


        return view;
    }

    private void createRecyclerCulture(){

    }

    private void createRecyclerClassification(){
        recyclerView = view.findViewById(R.id.recyclerview_filtro_id_teste);

        adapter = new RecyclerViewFiltroArtworkAdapter(getList());

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void createRecyclerGallery(){

    }

    public List<Classification> getList(){
        List<Classification> list = new ArrayList<>();

        Classification classification = new Classification();
        classification.setClassificationId(1);
        classification.setClassificationName("tetste");

        list.add(classification);

        return list;

    }

    @Override
    public void onSucess(Object object) {
        List<Classification> classificationList = (List<Classification>) object;
        adapter.setClassificationList(classificationList);
    }

    @Override
    public void onError(Throwable throwable) {
        Toast.makeText(getContext(), "teste", Toast.LENGTH_SHORT).show();
        Log.d("Classificacao: ", throwable.getLocalizedMessage());
    }
}
