package com.example.andreza.harvardmuseums.fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andreza.harvardmuseums.R;
import com.example.andreza.harvardmuseums.activity.HomeActivity;
import com.example.andreza.harvardmuseums.adapter.RecyclerViewArtworkAdapter;
import com.example.andreza.harvardmuseums.interfaces.ArtworkListenerDetail;
import com.example.andreza.harvardmuseums.interfaces.RecyclerListenerArtwork;
import com.example.andreza.harvardmuseums.pojo.Artwork;
import com.example.andreza.harvardmuseums.service.ServiceListener;
import com.example.andreza.harvardmuseums.model.dao.ArtworkDAO;
import com.squareup.picasso.Picasso;

import static com.example.andreza.harvardmuseums.activity.HomeActivity.OBJ_ARTWORK;

public class ArtworkDetailFragment extends Fragment implements ServiceListener {

    private ArtworkListenerDetail detailArtwork;
    private Artwork artwork;
    private TextView title;
    private ImageView imageDetail;
    private TextView classification;
    //private TextView worktype;
    private TextView date;
    private TextView places;
    private TextView period;
    private TextView culture;

    private ArtworkDAO dao;
    private ServiceListener listener;

    public ArtworkDetailFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.detailArtwork = (ArtworkListenerDetail) context;
        this.artwork = (Artwork) getArguments().getSerializable(HomeActivity.OBJ_ARTWORK);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_artwork_detail, container, false);

        title = view.findViewById(R.id.text_title_detail_artwork_id);
        imageDetail = view.findViewById(R.id.image_detail_artwork_id);
        date = view.findViewById(R.id.text_date_detail_artwork_id);
        classification = view.findViewById(R.id.text_classification_detail_artwork_id);
        period = view.findViewById(R.id.text_period_detail_artwork_id);
        culture = view.findViewById(R.id.text_culture_detail_artwork_id);

        setArtworkDetail();

        return view;
    }

    private void setArtworkDetail(){
        title.setText(artwork.getTitle());
        if (artwork.getPicture() != null){
            Picasso.get().load(artwork.getPicture()).into(imageDetail);
        }
        date.setText(artwork.getDate());
        classification.setText(artwork.getClassification());
        period.setText(artwork.getPeriod());
        culture.setText(artwork.getCulture());

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