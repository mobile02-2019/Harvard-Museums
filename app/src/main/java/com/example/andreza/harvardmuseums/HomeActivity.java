package com.example.andreza.harvardmuseums;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.andreza.harvardmuseums.fragment.ArtworkFragment;
import com.example.andreza.harvardmuseums.fragment.ExhibitionFragment;

public class HomeActivity extends AppCompatActivity {
    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        navigationView = (BottomNavigationView) findViewById(R.id.navigationView);
        showFragment(new ArtworkFragment());

    }

    public void showFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container_id, fragment);
        transaction.commit();
    }

     public void showMuseum(Fragment museumFragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container_id, museumFragment);
        transaction.commit();
    }

    public void showArtwork(Fragment artworkFragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container_id, artworkFragment);
        transaction.commit();
    }

    public void showUser(Fragment userFragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container_id, userFragment);
        transaction.commit();
    }

}
