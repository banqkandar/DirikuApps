package com.example.iskandar.dirikuapps.Presenter;
/**
 * Nama: Mohammad Iskandar
 * Nim: 10116121
 * Kelas: AKB-3 / IF-3
 * Tanggal Pengerjaan: 16 Mei 2019
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.iskandar.dirikuapps.Models.ProfileModel;
import com.example.iskandar.dirikuapps.R;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileViewHolder> {
    private Context context;
    List<ProfileModel> profileModels;

    public ProfileAdapter(Context context, List<ProfileModel> profileModels) {
        this.context = context;
        this.profileModels = profileModels;
    }

    @NonNull
    @Override
    public ProfileViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_gallery, viewGroup, false);
        return new ProfileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileViewHolder galleryViewHolder, int i) {
        ProfileModel profileModel = profileModels.get(i);
        galleryViewHolder.img_galeri.setImageResource(profileModel.getImage());
    }

    @Override
    public int getItemCount() {
        return profileModels.size();
    }
}

