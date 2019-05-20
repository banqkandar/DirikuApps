package com.example.iskandar.dirikuapps.Views;
/**
 * Nama: Mohammad Iskandar
 * Nim: 10116121
 * Kelas: AKB-3 / IF-3
 * Tanggal Pengerjaan: 16 Mei 2019
 */

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.iskandar.dirikuapps.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        navigation.setOnNavigationItemSelectedListener(monNavigationItemSelectedListener);
        loadfragment(new HomeFragment());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener monNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.navigation_homepage:
                    loadfragment(new HomeFragment());
                    return true;
                case R.id.navigation_friends:
                    loadfragment(new FriendsFragment());
                    return true;
                case R.id.navigation_contacts:
                    loadfragment(new ContactsFragment());
                    return true;
                case R.id.navigation_profile:
                    loadfragment(new ProfileFragment());
                    return true;
            }
            return false;
        }
    };

    void loadfragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.mainFrame, fragment);
        ft.commit();
    }
}
