package com.example.andreza.harvardmuseums.fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.andreza.harvardmuseums.R;
import com.example.andreza.harvardmuseums.interfaces.ArtworkListenerDetail;
import com.example.andreza.harvardmuseums.interfaces.RecyclerListenerArtwork;
import com.example.andreza.harvardmuseums.service.ServiceListener;
import com.example.andreza.harvardmuseums.adapter.RecyclerViewArtworkAdapter;
import com.example.andreza.harvardmuseums.pojo.Artwork;
import com.example.andreza.harvardmuseums.model.dao.ArtworkDAO;

import java.util.List;

public class ArtworkFragment extends Fragment implements ServiceListener, RecyclerListenerArtwork {

    private RecyclerView recyclerView;
    private RecyclerViewArtworkAdapter adapter;
    private ArtworkListenerDetail listenerArtwork;

    public ArtworkFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listenerArtwork = (ArtworkListenerDetail) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        View view = inflater.inflate(R.layout.fragment_artwork, container, false);

        ImageView filtro = view.findViewById(R.id.imageView_filter_id);
        filtro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Está funcionando!", Toast.LENGTH_SHORT).show();
            }
        });

        setupRecyclerView(view);

        return view;
    }

    private void setupRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.recyclerview_artwork_id);

        final ArtworkDAO dao = new ArtworkDAO();

        adapter = new RecyclerViewArtworkAdapter(dao.getArtList(getContext(),this), this);

        recyclerView.setAdapter(adapter);
        int columns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), columns));

    }

    @Override
    public void onSucess(Object object) {
        List<Artwork> artworkList = (List<Artwork>) object;
        adapter.setArtworkList(artworkList);
    }

    @Override
    public void onError(Throwable throwable) {
        Snackbar.make(recyclerView,throwable.getMessage(),Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onArtworkClicado(Artwork artwork) {
        listenerArtwork.iniciarFragmentArtworkDetail(artwork);
    }
}