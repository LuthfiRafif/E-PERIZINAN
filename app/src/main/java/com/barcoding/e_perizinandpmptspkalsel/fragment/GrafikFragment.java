package com.barcoding.e_perizinandpmptspkalsel.fragment;

import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.barcoding.e_perizinandpmptspkalsel.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;

public class GrafikFragment extends Fragment {

    private Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_grafik, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        toolbar = view.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Bar Chart");

        BarChart barChart = view.findViewById(R.id.barChart);

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry( 44f, 0));
        barEntries.add(new BarEntry( 44f, 0));
        barEntries.add(new BarEntry( 44f, 0));
        barEntries.add(new BarEntry( 44f, 0));
        barEntries.add(new BarEntry( 44f, 0));
        barEntries.add(new BarEntry( 44f, 0));
        BarDataSet barDataSet = new BarDataSet(barEntries, "Date");

        ArrayList<String> theDates = new ArrayList<>();
        theDates.add("Januari");
        theDates.add("Februari");
        theDates.add("Maret");
        theDates.add("April");
        theDates.add("Mei");
        theDates.add("Juni");

        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }
}
