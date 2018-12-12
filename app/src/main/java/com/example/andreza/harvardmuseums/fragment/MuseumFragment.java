package com.example.andreza.harvardmuseums.fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.andreza.harvardmuseums.R;

public class MuseumFragment extends Fragment {

    public Listener listener;

    public interface Listener {
        void goToMuseumDetail(int museumId);
    }

    public MuseumFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (Listener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        View view = inflater.inflate(R.layout.fragment_museum, container, false);
        ImageView iconMap1 = view.findViewById(R.id.imageView_fogg_id);
        ImageView imgMuseu1 = view.findViewById(R.id.imageMuseum1);


        imgMuseu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.goToMuseumDetail(1);
            }
        });


        iconMap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.goToMuseumDetail(1);
            }
        });


        ImageView imgMuseu2 = view.findViewById(R.id.imageMuseum2);
        ImageView iconMap2 = view.findViewById(R.id.imageView_busch_id);


        imgMuseu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.goToMuseumDetail(2);
            }
        });
        iconMap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.goToMuseumDetail(2);
            }
        });



        ImageView imgMuseu3 = view.findViewById(R.id.imageMuseum3);
        ImageView iconMap3 = view.findViewById(R.id.imageView_arthur_id);

        imgMuseu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.goToMuseumDetail(3);
            }
        });
        iconMap3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.goToMuseumDetail(3);
            }
        });

        return view;
    }

}