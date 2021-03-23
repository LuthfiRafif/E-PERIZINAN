package com.barcoding.e_perizinandpmptspkalsel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.barcoding.e_perizinandpmptspkalsel.fragment.AkunFragment;
import com.barcoding.e_perizinandpmptspkalsel.fragment.GrafikFragment;
import com.barcoding.e_perizinandpmptspkalsel.fragment.PerizinanFragment;
import com.barcoding.e_perizinandpmptspkalsel.fragment.TrackingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        openFragment(new PerizinanFragment());
    }

    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                     switch (item.getItemId()){
                         case R.id.nav_perizinan:
                             openFragment(new PerizinanFragment());
                             return true;
                         case R.id.nav_tracking:
                             openFragment(new TrackingFragment());
                             return true;
                         case R.id.nav_graphic:
                             openFragment(new GrafikFragment());
                             return true;
                         case R.id.nav_user:
                             openFragment(new AkunFragment());
                             return true;
                     }
                     return false;
                }
            };
    }