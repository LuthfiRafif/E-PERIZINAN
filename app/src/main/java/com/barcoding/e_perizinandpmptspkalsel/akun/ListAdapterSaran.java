package com.barcoding.e_perizinandpmptspkalsel.akun;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.barcoding.e_perizinandpmptspkalsel.R;

import java.util.List;

public class ListAdapterSaran extends ArrayAdapter {

    private String[] Saran;
    private String[] Tanggal;
    private Context context;

    public ListAdapterSaran(@NonNull Context context, String[] saran, String[] tanggal) {
        super(context, R.layout.costum_listview_saran, saran);
        this.Saran = saran;
        this.Tanggal = tanggal;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.costum_listview_saran, null, true);

        TextView saran = view.findViewById(R.id.tv_sn);
        TextView tanggal = view.findViewById(R.id.tv_tgl);


        saran.setText(Saran[position]);
        tanggal.setText(Tanggal[position]);
        return view;
    }
}
