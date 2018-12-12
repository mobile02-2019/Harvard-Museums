package com.example.andreza.harvardmuseums.fragment;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.icu.text.UnicodeMatcher;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andreza.harvardmuseums.R;
import com.example.andreza.harvardmuseums.activity.LoginActivity;
import com.example.andreza.harvardmuseums.adapter.RecyclerViewUserAdapter;
import com.example.andreza.harvardmuseums.adapter.SpacesItemDecoration;
import com.example.andreza.harvardmuseums.database.AppDatabase;
import com.example.andreza.harvardmuseums.interfaces.ArtworkListenerDetail;
import com.example.andreza.harvardmuseums.interfaces.ComunicadorRecyclerUser;
import com.example.andreza.harvardmuseums.pojo.Artwork;
import com.example.andreza.harvardmuseums.pojo.ArtworkRoom;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class UserFragment extends Fragment implements ComunicadorRecyclerUser {

    private ImageView imageProfile;
    private TextView username;
    private TextView userEmail;
    private FirebaseAuth mAuth;
    private AppDatabase db;
    private FirebaseDatabase database;
    private List<Artwork> artworkList = new ArrayList<>();
    private DatabaseReference mref;
    private RecyclerViewUserAdapter adapter;
    private Artwork artwork = new Artwork();
    private ArtworkListenerDetail listenerDetail;


    public UserFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listenerDetail = (ArtworkListenerDetail) context;


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();

        View view = inflater.inflate(R.layout.fragment_user, container, false);

        imageProfile = view.findViewById(R.id.user_image_id);
        username = view.findViewById(R.id.user_username_text_id);
        userEmail = view.findViewById(R.id.user_email_id);

        mAuth = FirebaseAuth.getInstance();

        FirebaseUser user = mAuth.getCurrentUser();

        if (user != null) {
            Picasso.get().load(user.getPhotoUrl()).into(imageProfile);
            username.setText(user.getDisplayName());
            userEmail.setText(user.getEmail());
        }

        db = Room.databaseBuilder(getActivity().getApplicationContext(),
                AppDatabase.class, "harvardmuseusmsdb-room").build();

        setupRecyclerView(view);

        Button buttonLogout = view.findViewById(R.id.user_logout_button_id);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                LoginManager.getInstance().logOut();
                goToLogin();
            }
        });



        return view;
    }

    private void goToLogin() {
        Intent intent = new Intent(getContext(), LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser()==null){
            Intent backToLogin = new Intent(getContext(),LoginActivity.class);
            startActivity(backToLogin);
        }
    }

    public void setupRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_user_id);
        adapter = new RecyclerViewUserAdapter(artworkList,this,listenerDetail);
        recyclerView.setAdapter(adapter);
        int columns = 2;
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        SpacesItemDecoration decoration = new SpacesItemDecoration(16);
        recyclerView.addItemDecoration(decoration);

        database = FirebaseDatabase.getInstance();

        mref = database.getReference("users/" + mAuth.getCurrentUser().getUid());

        mref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                GenericTypeIndicator<Map<String, Artwork>> genericTypeIndicator = new GenericTypeIndicator<Map<String, Artwork>>() {
                };
                if (dataSnapshot.getValue(genericTypeIndicator) != null) {
                    Collection<Artwork> artworkCollection = dataSnapshot.getValue(genericTypeIndicator).values();

                    List<Artwork> artworkList = new ArrayList<>(artworkCollection);


                    adapter.setFavoriteList(artworkList);

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });}







    @Override
    public void exluirFavorito(Artwork artwork) {
        adapter.excluirFavoritado(artwork);
        adapter.notifyDataSetChanged();
    }

}