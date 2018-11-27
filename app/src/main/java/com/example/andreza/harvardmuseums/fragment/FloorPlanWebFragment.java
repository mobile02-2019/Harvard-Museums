package com.example.andreza.harvardmuseums.fragment;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.andreza.harvardmuseums.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FloorPlanWebFragment extends Fragment {

private WebView wv;
    public FloorPlanWebFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_floor_plan_web, container, false);
         wv = view.findViewById(R.id.web_view_floor_plan_id);


        WebSettings ws = wv.getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setSupportZoom(false);
        wv.loadUrl("https://www.harvardartmuseums.org/visit/floor-plan/2");
        return view;
    }

}
