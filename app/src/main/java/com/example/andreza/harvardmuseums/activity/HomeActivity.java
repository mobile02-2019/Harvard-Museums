package com.example.andreza.harvardmuseums.activity;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.andreza.harvardmuseums.fragment.OpcoesFiltroArtworkFragment;
import com.example.andreza.harvardmuseums.R;
import com.example.andreza.harvardmuseums.fragment.ArtworkDetailFragment;
import com.example.andreza.harvardmuseums.fragment.ArtworkFragment;
import com.example.andreza.harvardmuseums.fragment.ExhibitionDetailFragment;
import com.example.andreza.harvardmuseums.fragment.ExhibitionFragment;
import com.example.andreza.harvardmuseums.fragment.FilterFragment;
import com.example.andreza.harvardmuseums.fragment.FloorPlanWebFragment;
import com.example.andreza.harvardmuseums.fragment.Museum1DetailFragment;
import com.example.andreza.harvardmuseums.fragment.Museum2DetailFragment;
import com.example.andreza.harvardmuseums.fragment.Museum3DetailFragment;
import com.example.andreza.harvardmuseums.fragment.MuseumFragment;
import com.example.andreza.harvardmuseums.fragment.UserFragment;
import com.example.andreza.harvardmuseums.interfaces.ArtworkListenerDetail;

import com.example.andreza.harvardmuseums.interfaces.ExhibitionListener;
import com.example.andreza.harvardmuseums.pojo.Artwork;
import com.example.andreza.harvardmuseums.pojo.Exhibition;
import com.google.firebase.messaging.FirebaseMessaging;

public class HomeActivity extends AppCompatActivity implements MuseumFragment.Listener,
        ArtworkListenerDetail,ExhibitionListener {

    public static final String TITULO = "titulo";
    public static final String OBJ_ARTWORK = "artwork";
    private static final String TAG = "HomeActivity";
    public static final String OBJ_EXHIBITION = "Exhibition";

    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView = findViewById(R.id.navigationView);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                switch (menuItem.getItemId()) {
                    case R.id.navigation_museum:
                        fragment = new MuseumFragment();
                        showFragment(fragment);
                        break;
                    case R.id.navigation_exhibition:
                       //TODO
                        fragment = new ExhibitionFragment();
                        showFragment(fragment);
                        break;
                    case R.id.navigation_artwork:
                        fragment = new ArtworkFragment();
                        showFragment(fragment);
                        break;
                    case R.id.navigation_floor_plan_id:
                        fragment = new FloorPlanWebFragment();
                        showFragment(fragment);
                        break;
                    case R.id.navigation_user:
                        fragment = new UserFragment();
                        showFragment(fragment);
                        break;

                }
                return true;
            }
        });
        showFragment(new MuseumFragment());

        //parte que libera a notificacao push
        FirebaseMessaging.getInstance().setAutoInitEnabled(true);
    }


    public void showFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container_id, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void goToMuseumDetail(int museumID) {

        if (museumID == 1) {
            showFragment(new Museum1DetailFragment());
        }
        if (museumID == 2) {
            showFragment(new Museum2DetailFragment());
        }
        if (museumID == 3) {
            showFragment(new Museum3DetailFragment());
        }

    }




    public void goToFilter(){
        showFragment(new FilterFragment());
    }

    public void goToArtwork(){
        showFragment(new ArtworkFragment());
    }

    @Override
    public void iniciarFragmentArtworkDetail(Artwork artwork) {
        ArtworkDetailFragment detailFragment = new ArtworkDetailFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable(OBJ_ARTWORK,artwork);
        detailFragment.setArguments(bundle);

        showFragment(detailFragment);
    }

    @Override
    public void openFragment(String title) {
//        Toast.makeText(this, title, Toast.LENGTH_SHORT).show();
        FragmentManager manager = getSupportFragmentManager();
        OpcoesFiltroArtworkFragment opcoesFiltroArtworkFragment = new OpcoesFiltroArtworkFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        opcoesFiltroArtworkFragment.setArguments(bundle);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container_id, opcoesFiltroArtworkFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    @Override
    public void iniciarExhibitionDetail(Exhibition exhibition) {
        ExhibitionDetailFragment exhibitionDetailFragment = new ExhibitionDetailFragment();

        Bundle bundle = new Bundle();
        bundle.putSerializable(OBJ_EXHIBITION, exhibition);
        exhibitionDetailFragment.setArguments(bundle);
        showFragment(exhibitionDetailFragment);

    }


}