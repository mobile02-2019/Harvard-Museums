package com.example.andreza.harvardmuseums.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andreza.harvardmuseums.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExhibitionDetailFragment extends Fragment {


    public ExhibitionDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exhibition_detail, container, false);
    }

}
