package com.example.iskandar.dirikuapps.Views;
/**
 * Nama: Mohammad Iskandar
 * Nim: 10116121
 * Kelas: AKB-3 / IF-3
 * Tanggal Pengerjaan: 18 Mei 2019
 */

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.iskandar.dirikuapps.Models.CRUD;
import com.example.iskandar.dirikuapps.R;
import java.util.Objects;

public class FriendsFragment extends Fragment {

    ListView lv;
    ArrayAdapter<String> adapter;
    CRUD crud = new CRUD();
    Dialog d;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friends, container, false);

        lv = view.findViewById(R.id.lv);
        lv.setOnItemClickListener((adapterView, view1, i, l) -> {
            if (d != null) {
                if (!d.isShowing()) {
                    displayInputDialog(i);
                } else {
                    d.dismiss();
                }
            }
        });

        final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayInputDialog(-1);
            }
        });

        return view;
    }

    private void displayInputDialog(final int pos) {
        d = new Dialog(Objects.requireNonNull(getActivity()));
        d.setContentView(R.layout.input_dialog);

        final EditText nameEditTxt = (EditText) d.findViewById(R.id.nameEditText);
        Button addBtn = (Button) d.findViewById(R.id.addBtn);
        Button updateBtn = (Button) d.findViewById(R.id.updateBtn);
        Button deleteBtn = (Button) d.findViewById(R.id.deleteBtn);

        if (pos == -1) {
            addBtn.setEnabled(true);
            updateBtn.setEnabled(false);
            deleteBtn.setEnabled(false);
        } else {
            addBtn.setEnabled(true);
            updateBtn.setEnabled(true);
            deleteBtn.setEnabled(true);
            nameEditTxt.setText(crud.getNames().get(pos));
        }

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GET DATA
                String name = nameEditTxt.getText().toString();

                //VALIDATE
                if (name.length() > 0 && name != null ) {
                    //save
                    crud.save(name);
                    nameEditTxt.setText("");
                    adapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), android.R.layout.simple_list_item_1, crud.getNames());

                    lv.setAdapter(adapter);
                    Toast.makeText(getActivity(), "Berhasil ditambah", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getActivity(), "Tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GET DATA
                String newName = nameEditTxt.getText().toString();

                //VALIDATE
                if (newName.length() > 0 && newName != null) {
                    //save
                    if (crud.update(pos, newName)) {
                        nameEditTxt.setText(newName);
                        adapter = new ArrayAdapter<>(Objects.requireNonNull(getActivity()), android.R.layout.simple_list_item_1, crud.getNames());

                        lv.setAdapter(adapter);
                        Toast.makeText(getActivity(), "Berhasil diupdate", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(getActivity(), "Tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //DELETE
                if (crud.delete(pos)) {
                    nameEditTxt.setText("");
                    adapter = new ArrayAdapter<String>(Objects.requireNonNull(getActivity()), android.R.layout.simple_list_item_1, crud.getNames());

                    lv.setAdapter(adapter);
                    Toast.makeText(getActivity(), "Berhasil dihapus", Toast.LENGTH_SHORT).show();
                }
            }
        });
        d.show();
    }
}
