package com.barcoding.e_perizinandpmptspkalsel.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.barcoding.e_perizinandpmptspkalsel.R;
import com.barcoding.e_perizinandpmptspkalsel.akun.BiodataActivity;
import com.barcoding.e_perizinandpmptspkalsel.akun.KeluhanActivity;
import com.barcoding.e_perizinandpmptspkalsel.akun.KontakActivity;
import com.barcoding.e_perizinandpmptspkalsel.akun.ListAdapterAkun;
import com.barcoding.e_perizinandpmptspkalsel.akun.SaranActivity;
import com.barcoding.e_perizinandpmptspkalsel.akun.TentangAplikasiActivity;

public class AkunFragment extends Fragment {

    ListView lv;
    private Toolbar toolbar;

    int[] Icon = new int[]{
            R.drawable.ic_person, R.drawable.ic_email, R.drawable.ic_drafts, R.drawable.ic_contact,
            R.drawable.ic_info, R.drawable.ic_logout
    };

    String[] Headline = {"Biodata", "Saran", "Keluhan", "Kontak Instansi",
            "Tentang Aplikasi", "Keluar Aplikasi"
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_akun, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        toolbar = view.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Profil");
        

        lv = view.findViewById(R.id.lv_list);
        ListAdapterAkun listAdapterAkun = new ListAdapterAkun(getContext(), Icon, Headline);
        lv.setAdapter(listAdapterAkun);
        lv.setOnItemClickListener((parent, view1, position, id) -> {

            if (position == 0) {
                Intent intent = new Intent(view1.getContext(), BiodataActivity.class);
                startActivityForResult(intent, 0);
            }

            if (position == 1) {
                Intent intent = new Intent(view1.getContext(), SaranActivity.class);
                startActivityForResult(intent, 0);
            }

            if (position == 2) {
                Intent intent = new Intent(view1.getContext(), KeluhanActivity.class);
                startActivityForResult(intent, 0);
            }

            if (position == 3) {
                Intent intent = new Intent(view1.getContext(), KontakActivity.class);
                startActivityForResult(intent, 0);
            }

            if (position == 4) {
                Intent intent = new Intent(view1.getContext(), TentangAplikasiActivity.class);
                startActivityForResult(intent, 0);
            }

        });
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }
}
