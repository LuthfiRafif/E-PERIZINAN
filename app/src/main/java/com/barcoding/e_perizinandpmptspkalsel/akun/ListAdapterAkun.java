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

public class ListAdapterAkun extends ArrayAdapter {

    private int[] Icon;
    private String[] Headline;
    private Context context;

    public ListAdapterAkun(@NonNull Context context, int[] icon, String[] headline) {
        super(context, R.layout.costum_listview_akun, headline);
        this.Icon = icon;
        this.Headline = headline;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.costum_listview_akun, null, true);
        ImageView icon = view.findViewById(R.id.imageList);
        TextView headline = view.findViewById(R.id.text_headline);

        icon.setImageResource(Icon[position]);
        headline.setText(Headline[position]);
        return view;
    }
}
