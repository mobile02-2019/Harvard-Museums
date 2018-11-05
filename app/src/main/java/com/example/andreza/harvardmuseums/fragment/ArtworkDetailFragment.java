package com.example.andreza.harvardmuseums.fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.andreza.harvardmuseums.R;
import com.example.andreza.harvardmuseums.Service.ServiceListener;
import com.example.andreza.harvardmuseums.adapter.RecyclerViewArtworkAdapter;
import com.example.andreza.harvardmuseums.interfaces.ComunicacaoArtwork;
import com.example.andreza.harvardmuseums.model.Artwork;
import com.example.andreza.harvardmuseums.model.dao.ArtworkDAO;

public class ArtworkDetailFragment extends Fragment implements ServiceListener {

    private RecyclerViewArtworkAdapter adapter;
    private RecyclerView recyclerView;
    private ComunicacaoArtwork comunicacaoArtwork;

    public ArtworkDetailFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.comunicacaoArtwork = (ComunicacaoArtwork) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_artwork_detail, container, false);

        setupDAO();

        Bundle bundle = getArguments();


        comunicacaoArtwork.enviarMensagens();

        return view;
    }

    public void setupDAO(){

        final ArtworkDAO dao = new ArtworkDAO();

        dao.getArtList(getContext(),this);

        //recyclerView = view.findViewById(R.id.recyclerview_artwork_id);
        //adapter = new RecyclerViewArtworkAdapter(dao.getArtList(getContext(),this));

        //recyclerView.setAdapter(adapter);
        //recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    @Override
    public void onSucess(Object object) {
        Artwork artwork = (Artwork) object;
        //adapter.setArtwork(artwork);
    }

    @Override
    public void onError(Throwable throwable) {
        Snackbar.make(recyclerView,throwable.getMessage(),Snackbar.LENGTH_LONG).show();
    }
}