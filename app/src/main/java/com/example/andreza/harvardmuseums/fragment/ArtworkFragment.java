package com.example.andreza.harvardmuseums.fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;
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
    private Toolbar filterToolbar;
    public static final String CHAVE_KEY = "chave_key";
    private int page = 1;
    private final int PAGE_SIZE = 20;


    public ArtworkFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listenerArtwork = (ArtworkListenerDetail) context;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        View view = inflater.inflate(R.layout.fragment_artwork, container, false);
//
//        ImageView filtro = view.findViewById(R.id.imageView_filter_id);
//
//        filtro.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
////                Toast.makeText(getContext(), "Está funcionando!", Toast.LENGTH_SHORT).show();
//
//                }
//        });

        filterToolbar = view.findViewById(R.id.filter_toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(filterToolbar);

        setupRecyclerView(view);
        this.setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_filtro, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        listenerArtwork.openFragment(item.getTitle().toString());



        return true;
    }


//    private void openFragment() {
//        FragmentManager manager = getContext().getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        fragment = new CriarContatoFragment();
//        transaction.replace(R.id.container_id, fragment);
//        transaction.commit();
//    }


    private void setupRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.recyclerview_artwork_id);

        final ArtworkDAO dao = new ArtworkDAO();
        adapter = new RecyclerViewArtworkAdapter(dao.getArtList(getContext(),this,PAGE_SIZE,page), this);
        recyclerView.setAdapter(adapter);
        int columns = 2;
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (!recyclerView.canScrollVertically(1)) {

                    // Aumentar o offset (quantidade de itens que são "pulados" na busca paginada
                    // O offset sempre aumenta de acordo com a constante POST_LIMIT definida no dao
                    page = page +1 ;

                    // Chamar o método que busca Posts de forma paginada, porém com o novo offset
                    ArtworkDAO dao = new ArtworkDAO();
                    dao.getArtDetailList(getContext(),ArtworkFragment.this,page,PAGE_SIZE);
                }
            }
        });

    }

    @Override
    public void onSucess(Object object) {
        List<Artwork> artworkList = (List<Artwork>) object;
        adapter.addArtworkList(artworkList);
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

