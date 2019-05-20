package com.example.iskandar.dirikuapps.Presenter;
/**
 * Nama: Mohammad Iskandar
 * Nim: 10116121
 * Kelas: AKB-3 / IF-3
 * Tanggal Pengerjaan: 16 Mei 2019
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.example.iskandar.dirikuapps.Views.ViewPager.ViewPager1;
import com.example.iskandar.dirikuapps.Views.ViewPager.ViewPager2;
import com.example.iskandar.dirikuapps.Views.ViewPager.ViewPager3;

public class OnBoardActivityAdapter extends FragmentStatePagerAdapter {
    public OnBoardActivityAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                ViewPager1 onBoard1 = new ViewPager1();
                return onBoard1;
            case 1:
                ViewPager2 onBoard2 = new ViewPager2();
                return onBoard2;
            case 2:
                ViewPager3 onBoard3 = new ViewPager3();
                return onBoard3;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int i) {
        switch (i) {
            case 0:
                return "onboard1";
            case 1:
                return "onboard2";
            case 2:
                return "onboard3";
        }
        return null;
    }
}
