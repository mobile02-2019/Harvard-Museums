package com.example.andreza.harvardmuseums;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class OpcoesFiltroArtworkFragment extends Fragment {


    public OpcoesFiltroArtworkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        String title = bundle.getString("title");

        if (title == "Classification") {
            createRecyclerClassification();
        }

        if (title == "Gallery") {
            createRecyclerGallery();
        }

        if (title == "Culture") {
            createRecyclerCulture();
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_opcoes_filtro_artwork, container, false);
    }

    private void createRecyclerCulture(){

    }

    private void createRecyclerClassification(){

    }

    private void createRecyclerGallery(){

    }



}
