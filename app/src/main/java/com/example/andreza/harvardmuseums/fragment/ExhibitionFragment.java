package com.example.andreza.harvardmuseums.fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.andreza.harvardmuseums.R;
import com.example.andreza.harvardmuseums.adapter.RecyclerViewExhibitionAdapter;
import com.example.andreza.harvardmuseums.model.Exhibition;
import java.util.ArrayList;
import java.util.List;

public class ExhibitionFragment extends Fragment {


    public ExhibitionFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().show();

        View view = inflater.inflate(R.layout.fragment_exhibition, container, false);
        setupRecyclerView(view);
        return view;
    }

    private void setupRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_exhibition_id);
        RecyclerViewExhibitionAdapter adapter = new RecyclerViewExhibitionAdapter(createExhibitionList());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    private List<Exhibition> createExhibitionList(){
        List<Exhibition> exhibitionList = new ArrayList<>();

        Exhibition exhibition1 = new Exhibition();
        exhibition1.setTitle("Animal-Shaped Vessels from the Ancient World: Feasting with Gods, Heroes, and Kings");
        exhibition1.setDate("September 7, 2018–January 6, 2019");
        exhibitionList.add(exhibition1);

        Exhibition exhibition2 = new Exhibition();
        exhibition2.setTitle("Mutiny: Works by Géricault");
        exhibition2.setDate("September 1, 2018–January 6, 2019");
        exhibitionList.add(exhibition2);

        Exhibition exhibition3 = new Exhibition();
        exhibition3.setTitle("Adam and Eve");
        exhibition3.setDate("September 1, 2018–January 6, 2019");
        exhibitionList.add(exhibition3);

        return exhibitionList;
    }

}
