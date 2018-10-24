package com.example.andreza.harvardmuseums.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andreza.harvardmuseums.R;
import com.example.andreza.harvardmuseums.adapter.RecyclerViewArtworkAdapter;
import com.example.andreza.harvardmuseums.adapter.RecyclerViewExhibitionAdapter;
import com.example.andreza.harvardmuseums.model.Artwork;
import com.example.andreza.harvardmuseums.model.Exhibition;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtworkFragment extends Fragment {


    public ArtworkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_artwork, container, false);
        setupRecyclerView(view);
        return view;
    }

    private void setupRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_artwork_id);
        RecyclerViewArtworkAdapter adapter = new RecyclerViewArtworkAdapter(createArtworkList());
        recyclerView.setAdapter(adapter);
        int columns = 2;
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(),columns));

    }

    private List<Artwork> createArtworkList(){
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


        return artworkList;
    }

}
