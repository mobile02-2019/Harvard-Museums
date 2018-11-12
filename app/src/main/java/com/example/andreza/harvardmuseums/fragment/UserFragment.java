package com.example.andreza.harvardmuseums.fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.andreza.harvardmuseums.R;
import com.example.andreza.harvardmuseums.adapter.RecyclerViewUserAdapter;
import com.example.andreza.harvardmuseums.pojo.Artwork;
import java.util.ArrayList;
import java.util.List;

public class UserFragment extends Fragment {

    private Listener listener;

    public interface Listener {
        void goToArtworkDetail();
    }

    public UserFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (Listener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        View view = inflater.inflate(R.layout.fragment_user, container, false);
        setupRecyclerView(view);
        return view;
    }

    public void setupRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_user_id);
        RecyclerViewUserAdapter adapter = new RecyclerViewUserAdapter(createFavoriteList(), listener);
        recyclerView.setAdapter(adapter);
        int columns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(),columns));

    }

    public List<Artwork> createFavoriteList() {
        List<Artwork> favoriteList = new ArrayList<>();

        Artwork artwork = new Artwork();
        artwork.setTitle("Obra 1");
        favoriteList.add(artwork);

        Artwork artwork2 = new Artwork();
        artwork2.setTitle("Obra 2");
        favoriteList.add(artwork2);

        Artwork artwork3 = new Artwork();
        artwork3.setTitle("Obra 3");
        favoriteList.add(artwork3);

        Artwork artwork4 = new Artwork();
        artwork4.setTitle("Obra 4");
        favoriteList.add(artwork4);

        return favoriteList;

    }
}