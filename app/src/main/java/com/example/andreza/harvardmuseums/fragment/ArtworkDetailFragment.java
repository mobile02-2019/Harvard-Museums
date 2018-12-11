package com.example.andreza.harvardmuseums.fragment;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andreza.harvardmuseums.R;
import com.example.andreza.harvardmuseums.User;
import com.example.andreza.harvardmuseums.activity.HomeActivity;
import com.example.andreza.harvardmuseums.adapter.RecyclerViewArtworkAdapter;
import com.example.andreza.harvardmuseums.database.AppDatabase;
import com.example.andreza.harvardmuseums.interfaces.ArtworkListenerDetail;
import com.example.andreza.harvardmuseums.interfaces.RecyclerListenerArtwork;
import com.example.andreza.harvardmuseums.pojo.Artwork;
import com.example.andreza.harvardmuseums.pojo.ArtworkRoom;
import com.example.andreza.harvardmuseums.service.ServiceListener;
import com.example.andreza.harvardmuseums.model.dao.ArtworkDAO;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

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
    private ImageView share;
    private ImageView favorito;
    private List<Artwork> artworkList = new ArrayList<>();
    private ArtworkDAO dao;
    private ServiceListener listener;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private User user;
    private FirebaseAuth firebaseAuth;
    private AppDatabase db;

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


        firebaseAuth = FirebaseAuth.getInstance();


        title = view.findViewById(R.id.text_title_detail_artwork_id);
        imageDetail = view.findViewById(R.id.image_detail_artwork_id);
        date = view.findViewById(R.id.text_date_detail_artwork_id);
        classification = view.findViewById(R.id.text_classification_detail_artwork_id);
        period = view.findViewById(R.id.text_period_detail_artwork_id);
        culture = view.findViewById(R.id.text_culture_detail_artwork_id);
        share = view.findViewById(R.id.image_share_id);
        favorito = view.findViewById(R.id.image_favorito_id);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onShareClicado(artwork);
            }
        });

        favorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarArtes(artwork);
                Toast.makeText(getContext(), "Artwork saved!", Toast.LENGTH_SHORT).show();
            }
        });

        setArtworkDetail();

        db = Room.databaseBuilder(getActivity().getApplicationContext(),
                AppDatabase.class, "harvardmuseusmsdb-room").build();

        return view;
    }

    private void salvarArtes(Artwork artwork) {

        artworkList.add(artwork);

        mFirebaseInstance = FirebaseDatabase.getInstance();

        mFirebaseDatabase = mFirebaseInstance.getReference("users/" + firebaseAuth.getUid());

        DatabaseReference push = mFirebaseDatabase.push();

        artwork.setDatabaseKey(push.getKey());

        push.setValue(artwork);

        // Metodo para utilizar o Room
//        final ArtworkRoom artworkRoom = new ArtworkRoom();
//
//        artworkRoom.setId(artwork.getId());
//        artworkRoom.setTitle(artwork.getTitle());
//        artworkRoom.setPicture(artwork.getPicture());
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                db.artworkRoomDao().insertAll(artworkRoom);
//
//            }
//        }).start();
        // Termina aqui o metodo Room

    }

    private void onShareClicado(Artwork artwork) {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_SUBJECT, artwork.getTitle());
        share.putExtra(Intent.EXTRA_TEXT, artwork.getPicture());
        startActivity(Intent.createChooser(share, artwork.getDate()));
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