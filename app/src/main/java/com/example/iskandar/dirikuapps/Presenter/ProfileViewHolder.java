package com.example.iskandar.dirikuapps.Presenter;
/**
 * Nama: Mohammad Iskandar
 * Nim: 10116121
 * Kelas: AKB-3 / IF-3
 * Tanggal Pengerjaan: 16 Mei 2019
 */

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.example.iskandar.dirikuapps.R;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

class ProfileViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.imgGallery)
    ImageView img_galeri;
    private ArrayList<String> profileListModel = new ArrayList<>();

    public ProfileViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setItem(ArrayList<String> item) {
        //penerima value dari adapter
        profileListModel = item;
    }
}
