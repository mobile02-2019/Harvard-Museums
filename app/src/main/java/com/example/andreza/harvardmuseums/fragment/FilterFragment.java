package com.example.andreza.harvardmuseums.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andreza.harvardmuseums.R;
import com.example.andreza.harvardmuseums.adapter.RecyclerViewFilterAdapter;
import com.example.andreza.harvardmuseums.pojo.Gallery;

import java.util.ArrayList;
import java.util.List;

public class FilterFragment extends android.support.v4.app.Fragment {

    public FilterFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_filter, container, false);
        setupRecyclerView(view);
        return view;

    }

    private void setupRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_gallery_filter_id);
        RecyclerViewFilterAdapter adapter = new RecyclerViewFilterAdapter(createGalleryList());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }


    public List<Gallery> createGalleryList(){
        List<Gallery> galleryList = new ArrayList<>();

        Gallery gallery = new Gallery();
        gallery.setGalleryName("Galeria 1");
        Gallery gallery2 = new Gallery();
        gallery2.setGalleryName("Galeria 2");
        Gallery gallery3 = new Gallery();
        gallery3.setGalleryName("Galeria 3");
        Gallery gallery4 = new Gallery();
        gallery4.setGalleryName("Galeria 4");
        Gallery gallery5= new Gallery();
        gallery5.setGalleryName("Galeria 5");
        Gallery gallery6 = new Gallery();
        gallery6.setGalleryName("Galeria 6");
        Gallery gallery7 = new Gallery();
        gallery7.setGalleryName("Galeria 7");
        Gallery gallery8 = new Gallery();
        gallery8.setGalleryName("Galeria 8");
        Gallery gallery9 = new Gallery();
        gallery9.setGalleryName("Galeria 9");
        Gallery gallery10 = new Gallery();
        gallery10.setGalleryName("Galeria 10");
        galleryList.add(gallery);
        galleryList.add(gallery2);
        galleryList.add(gallery3);
        galleryList.add(gallery4);
        galleryList.add(gallery5);
        galleryList.add(gallery6);
        galleryList.add(gallery7);
        galleryList.add(gallery8);
        galleryList.add(gallery9);
        galleryList.add(gallery10);

        return galleryList;

    }

}
