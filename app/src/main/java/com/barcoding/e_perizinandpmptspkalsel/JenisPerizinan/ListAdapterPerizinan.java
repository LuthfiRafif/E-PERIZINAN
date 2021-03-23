package com.barcoding.e_perizinandpmptspkalsel.JenisPerizinan;

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

public class ListAdapterPerizinan extends ArrayAdapter {

    private String[] Headline;
    private Context context;

    public ListAdapterPerizinan(@NonNull Context context, String[] headline) {
        super(context, R.layout.costum_listview_perizinan, headline);
        this.Headline = headline;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.costum_listview_perizinan, null, true);

        TextView headline = view.findViewById(R.id.text_headline);

        headline.setText(Headline[position]);
        return view;
    }
}
