package com.example.andreza.harvardmuseums;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.andreza.harvardmuseums.fragment.ArtworkFragment;
import com.example.andreza.harvardmuseums.fragment.ExhibitionFragment;
import com.example.andreza.harvardmuseums.fragment.MuseumFragment;
import com.example.andreza.harvardmuseums.fragment.UserFragment;

public class HomeActivity extends AppCompatActivity {
    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
        transaction.commit();
    }

   /*   public void showMuseum(Fragment museumFragment) {
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
   */

    /*      loadFragment(new EmailFragment());

            BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bnvMenu);


        private void loadFragment(Fragment fragment) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.flContainer, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }*/
}
