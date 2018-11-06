package com.example.andreza.harvardmuseums.activity;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.andreza.harvardmuseums.R;
import com.example.andreza.harvardmuseums.fragment.ArtworkDetailFragment;
import com.example.andreza.harvardmuseums.fragment.ArtworkFragment;
import com.example.andreza.harvardmuseums.fragment.ExhibitionDetailFragment;
import com.example.andreza.harvardmuseums.fragment.ExhibitionFragment;
import com.example.andreza.harvardmuseums.fragment.FilterFragment;
import com.example.andreza.harvardmuseums.fragment.Museum1DetailFragment;
import com.example.andreza.harvardmuseums.fragment.Museum2DetailFragment;
import com.example.andreza.harvardmuseums.fragment.Museum3DetailFragment;
import com.example.andreza.harvardmuseums.fragment.MuseumFragment;
import com.example.andreza.harvardmuseums.fragment.UserFragment;
import com.example.andreza.harvardmuseums.interfaces.ComunicacaoArtwork;
import com.example.andreza.harvardmuseums.model.Artwork;
import com.example.andreza.harvardmuseums.model.Exhibition;

public class HomeActivity extends AppCompatActivity implements MuseumFragment.Listener,
        ExhibitionFragment.Listener, ArtworkFragment.Listener, ExhibitionDetailFragment.Listener,
        UserFragment.Listener{

    public static final String TITULO = "titulo";

    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
                    case R.id.navigation_user:
                        fragment = new UserFragment();
                        showFragment(fragment);
                        break;
                }
                return true;
            }
        });
        showFragment(new MuseumFragment());

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


  @Override
    public void goToExhibitionDetail(){
        showFragment(new ExhibitionDetailFragment());
  }

  @Override
  public void goToArtworkDetail(){
        showFragment(new ArtworkDetailFragment());
    }

    public void goToFilter(){
        showFragment(new FilterFragment());
    }

    public void goToArtwork(){
        showFragment(new ArtworkFragment());
    }



}