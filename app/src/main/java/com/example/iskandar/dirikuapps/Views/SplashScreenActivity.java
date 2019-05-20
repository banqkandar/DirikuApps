package com.example.iskandar.dirikuapps.Views;
/**
 * Nama: Mohammad Iskandar
 * Nim: 10116121
 * Kelas: AKB-3 / IF-3
 * Tanggal Pengerjaan: 16 Mei 2019
 */

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.iskandar.dirikuapps.R;

public class SplashScreenActivity extends AppCompatActivity {
    private int loadTime = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getApplication(), ViewPagerActivity.class);
                startActivity(i);
                finish();
            }
        }, loadTime);
    }
}