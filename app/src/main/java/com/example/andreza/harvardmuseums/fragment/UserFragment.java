package com.example.andreza.harvardmuseums.fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andreza.harvardmuseums.R;
import com.example.andreza.harvardmuseums.activity.HomeActivity;
import com.example.andreza.harvardmuseums.activity.LoginActivity;
import com.example.andreza.harvardmuseums.adapter.RecyclerViewUserAdapter;
import com.example.andreza.harvardmuseums.pojo.Artwork;
import com.facebook.CallbackManager;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class UserFragment extends Fragment {

    private Listener listener;
    private ImageView imageProfile;
    private TextView username;
    private TextView userEmail;
    private FirebaseAuth mAuth;

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