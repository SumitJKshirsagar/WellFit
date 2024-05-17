package com.example.wellfit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;


import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private HomeFragment homeFragment;
    private DiscoverFragment discoverFragment;
    private BarbelFragment barbelFragment;
    private SettingsFragment settingsFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = item -> {
        int itemId = item.getItemId();

        if (itemId == R.id.navigation_home) {
            setUpFragment(homeFragment);
            return true;
        } else if (itemId == R.id.navigation_barbell_dumble) {
            setUpFragment(barbelFragment);
            return true;
        } else if (itemId == R.id.navigation_discover) {
            setUpFragment(discoverFragment);
            return true;
        } else if (itemId == R.id.navigation_settings) {
            setUpFragment(settingsFragment);
            return true;
        } else {
            return false;
        }
    };

    private void setUpFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
        fragmentTransaction.replace(R.id.home_view,fragment);
        fragmentTransaction.commit();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();


        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        BottomNavHelp.removeShiftMode(bottomNavigationView);

        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.home_view,homeFragment);
        beginTransaction.commit();
    }

    private void initViews() {
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.navigation);
        homeFragment = HomeFragment.newInstance();
        barbelFragment = BarbelFragment.newInstance();
        discoverFragment = DiscoverFragment.newInstance();
        settingsFragment = SettingsFragment.newInstance();

    }



}






