package com.barcoding.e_perizinandpmptspkalsel.akun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.barcoding.e_perizinandpmptspkalsel.R;

public class ListAdapterKeluhan extends ArrayAdapter {

    private String[] Keluhan;
    private String[] Tanggal;
    private Context context;

    public ListAdapterKeluhan(@NonNull Context context, String[] keluhan, String[] tanggal) {
        super(context, R.layout.costum_listview_keluhan, keluhan);
        this.Keluhan = keluhan;
        this.Tanggal = tanggal;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.costum_listview_keluhan, null, true);

        TextView keluhan = view.findViewById(R.id.tv_sn);
        TextView tanggal = view.findViewById(R.id.tv_tgl);



        keluhan.setText(Keluhan[position]);
        tanggal.setText(Tanggal[position]);
        return view;
    }
}
