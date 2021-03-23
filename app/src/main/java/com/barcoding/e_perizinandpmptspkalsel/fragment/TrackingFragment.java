package com.barcoding.e_perizinandpmptspkalsel.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

public class TrackingFragment extends Fragment {

    private Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tracking, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        toolbar = view.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Tracking Berkas");

    }
    private void setSupportActionBar(Toolbar toolbar) {
    }
}
