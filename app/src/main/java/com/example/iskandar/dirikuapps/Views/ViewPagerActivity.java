package com.example.iskandar.dirikuapps.Views;
/**
 * Nama: Mohammad Iskandar
 * Nim: 10116121
 * Kelas: AKB-3 / IF-3
 * Tanggal Pengerjaan: 16 Mei 2019
 */

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.iskandar.dirikuapps.Presenter.OnBoardActivityAdapter;
import com.example.iskandar.dirikuapps.R;

public class ViewPagerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pagerOnBoard);
        OnBoardActivityAdapter onBoardActivityAdapter = new OnBoardActivityAdapter(getSupportFragmentManager());
        viewPager.setAdapter(onBoardActivityAdapter);
    }
}
