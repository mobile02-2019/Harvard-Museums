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
import com.example.andreza.harvardmuseums.R;
import com.example.andreza.harvardmuseums.Service.ServiceListener;
import com.example.andreza.harvardmuseums.adapter.RecyclerViewArtworkAdapter;
import com.example.andreza.harvardmuseums.model.Artwork;
import com.example.andreza.harvardmuseums.model.dao.ArtworkDAO;

import java.util.ArrayList;
import java.util.List;

public class ArtworkFragment extends Fragment implements ServiceListener {

    private RecyclerView recyclerView;
    private RecyclerViewArtworkAdapter adapter;
    private Listener listener;

    public interface Listener {
        void goToArtworkDetail();
    }

    public ArtworkFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener = (Listener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        View view = inflater.inflate(R.layout.fragment_artwork, container, false);
        setupRecyclerView(view);
        return view;
    }

    private void setupRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.recyclerview_artwork_id);

        final ArtworkDAO dao = new ArtworkDAO();

        adapter = new RecyclerViewArtworkAdapter(dao.getArtList(getContext(), this), listener);
        //RecyclerViewArtworkAdapter adapter = new RecyclerViewArtworkAdapter(createArtworkList(), listener);
        recyclerView.setAdapter(adapter);
        int columns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), columns));

    }

    private List<Artwork> createArtworkList() {
        List<Artwork> artworkList = new ArrayList<>();

        Artwork artwork = new Artwork();
        artwork.setTitle("Obra 1");
        artworkList.add(artwork);

        Artwork artwork2 = new Artwork();
        artwork2.setTitle("Obra 2");
        artworkList.add(artwork2);

        Artwork artwork3 = new Artwork();
        artwork3.setTitle("Obra 3");
        artworkList.add(artwork3);

        Artwork artwork4 = new Artwork();
        artwork4.setTitle("Obra 4");
        artworkList.add(artwork4);

        Artwork artwork5 = new Artwork();
        artwork5.setTitle("Obra 5");
        artworkList.add(artwork5);

        Artwork artwork6 = new Artwork();
        artwork6.setTitle("Obra 6");
        artworkList.add(artwork6);

        Artwork artwork7 = new Artwork();
        artwork7.setTitle("Obra 7");
        artworkList.add(artwork7);

        return artworkList;
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

}