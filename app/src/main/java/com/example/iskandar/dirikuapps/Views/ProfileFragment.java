package com.example.iskandar.dirikuapps.Views;
/**
 * Nama: Mohammad Iskandar
 * Nim: 10116121
 * Kelas: AKB-3 / IF-3
 * Tanggal Pengerjaan: 17 Mei 2019
 */

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.iskandar.dirikuapps.Models.ProfileModel;
import com.example.iskandar.dirikuapps.Presenter.ProfileAdapter;
import com.example.iskandar.dirikuapps.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileFragment extends Fragment {

    @BindView(R.id.rvGallery)
    RecyclerView rvGallery;
    List<ProfileModel> galleryModelList;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ProfileFragment() {
    }

    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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
        View viewFragment = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, viewFragment);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        initData();
        rvGallery.setLayoutManager(gridLayoutManager);
        rvGallery.setHasFixedSize(true);
        ProfileAdapter profileAdapter = new ProfileAdapter(getContext(), galleryModelList);
        rvGallery.setAdapter(profileAdapter);
        return viewFragment;
    }

    private void initData() {
        galleryModelList = new ArrayList<>();
        galleryModelList.add(new ProfileModel(R.drawable.gl1));
        galleryModelList.add(new ProfileModel(R.drawable.g1));
        galleryModelList.add(new ProfileModel(R.drawable.gl1));
        galleryModelList.add(new ProfileModel(R.drawable.g1));
        galleryModelList.add(new ProfileModel(R.drawable.gl4));
        galleryModelList.add(new ProfileModel(R.drawable.gl4));
        galleryModelList.add(new ProfileModel(R.drawable.gl1));
        galleryModelList.add(new ProfileModel(R.drawable.g1));
        galleryModelList.add(new ProfileModel(R.drawable.gl4));
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


    @OnClick(R.id.tvAbout)
    public void about() {
        CustomDialog customDialog = new CustomDialog();
        customDialog.showDialog(getActivity(), "NIM: 10116121 \n KELAS: AKB-3 \n UNIKOM");
    }

    @OnClick(R.id.tvCall)
    public void call() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:082122664210"));
        startActivity(intent);
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
