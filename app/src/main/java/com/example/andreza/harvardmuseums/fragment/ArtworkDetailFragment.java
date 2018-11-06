package com.example.andreza.harvardmuseums.fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.andreza.harvardmuseums.R;
import com.example.andreza.harvardmuseums.service.ServiceListener;
import com.example.andreza.harvardmuseums.adapter.RecyclerViewArtworkAdapter;
import com.example.andreza.harvardmuseums.interfaces.ComunicacaoArtwork;
import com.example.andreza.harvardmuseums.model.dao.ArtworkDAO;

public class ArtworkDetailFragment extends Fragment implements ArtworkFragment.Listener {

    private RecyclerViewArtworkAdapter adapter;
    private RecyclerView recyclerView;
    private ComunicacaoArtwork comunicacaoArtwork;
    private TextView titulo;
    private ArtworkDAO dao = new ArtworkDAO();
    private ServiceListener listener;

    public ArtworkDetailFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        this.comunicacaoArtwork = (ComunicacaoArtwork) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_artwork_detail, container, false);

       // Bundle bundle = getArguments();


        //comunicacaoArtwork.enviarMensagens();

        return view;
    }


    @Override
    public void goToArtworkDetail() {
        titulo.setText(dao.getArtList(getContext(),listener).get(0).getTitle());
    }
}