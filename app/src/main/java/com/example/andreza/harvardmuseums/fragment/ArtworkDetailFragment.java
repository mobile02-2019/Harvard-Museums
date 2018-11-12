package com.example.andreza.harvardmuseums.fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andreza.harvardmuseums.R;
import com.example.andreza.harvardmuseums.pojo.Artwork;
import com.example.andreza.harvardmuseums.service.ServiceListener;
import com.example.andreza.harvardmuseums.adapter.RecyclerViewArtworkAdapter;
import com.example.andreza.harvardmuseums.interfaces.ComunicacaoArtwork;
import com.example.andreza.harvardmuseums.model.dao.ArtworkDAO;

import java.util.List;

import static com.example.andreza.harvardmuseums.activity.HomeActivity.ID_ARTWORK;

public class ArtworkDetailFragment extends Fragment implements ArtworkFragment.Listener,ServiceListener {

    private ComunicacaoArtwork comunicacaoArtwork;
    private TextView titulo;
    private TextView title;
    private TextView classification;
    //private TextView worktype;
    private TextView date;
    private TextView places;
    private TextView period;
    private TextView culture;

    private ArtworkDAO dao;
    private ServiceListener listener;
    public static final String ID_ARTWORK = "id";
    public ArtworkDetailFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_artwork_detail, container, false);

        /*List<Artwork> lstArt= dao.getArtList(getContext(), this);

        title = view.findViewById(R.id.text_title_detail_artwork_id);
        classification = view.findViewById(R.id.text_classification_detail_artwork_id);
        date = view.findViewById(R.id.text_date_detail_artwork_id);
        places = view.findViewById(R.id.text_places_detail_artwork_id);
        period = view.findViewById(R.id.text_period_detail_artwork_id);
        culture = view.findViewById(R.id.text_culture_detail_artwork_id);

        Bundle bundle = new Bundle();
        int id = bundle.getInt(ID_ARTWORK);
        Artwork artDetail  = new Artwork();
        for (Artwork art : lstArt) {
            if (art.getId() == id){
                artDetail = art;
            }
        }

        title.setText(artDetail.getTitle());
        classification.setText(artDetail.getClassification());
        date.setText(artDetail.getDate());
        places.setText(artDetail.getPlaceCreation());
        period.setText(artDetail.getPeriod());
        culture.setText(artDetail.getCulture());
*/
        return view;
    }


    @Override
    public void goToArtworkDetail() {
        titulo.setText(dao.getArtList(getContext(),listener).get(0).getTitle());
    }

    @Override
    public void onSucess(Object object) {
        Artwork artwork = (Artwork) object;

    }

    @Override
    public void onError(Throwable throwable) {
        Toast.makeText(getContext(),"Erro",Toast.LENGTH_LONG).show();
    }
}