package com.example.iskandar.dirikuapps.Views;
/**
 * Nama: Mohammad Iskandar
 * Nim: 10116121
 * Kelas: AKB-3 / IF-3
 * Tanggal Pengerjaan: 16 Mei 2019
 */

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dinuscxj.progressbar.CircleProgressBar;
import com.example.iskandar.dirikuapps.R;
import com.nineoldandroids.animation.ValueAnimator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeFragment extends Fragment {
    @BindView(R.id.CircleAndroid)
    CircleProgressBar CircleAndroid;
    @BindView(R.id.CircleWeb)
    CircleProgressBar CircleWeb;
    @BindView(R.id.CircleTechSoft)
    CircleProgressBar CircleTechSoft;
    @BindView(R.id.CircleUI)
    CircleProgressBar CircleUI;
    private static final String DEFAULT_PATTERN = "%d%%";

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {

    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, myView);
        simulateProgress(0, 88, CircleAndroid);
        simulateProgress(0, 90, CircleWeb);
        simulateProgress(0, 92, CircleTechSoft);
        simulateProgress(0, 90, CircleUI);
        return myView;
    }

    private void simulateProgress(int min, int max, final CircleProgressBar circleProgressBar) {
        ValueAnimator animator = ValueAnimator.ofInt(min, max);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int progress = (int) animation.getAnimatedValue();
                circleProgressBar.setProgress(progress);
            }
        });
        animator.setDuration(3000);
        animator.start();
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
