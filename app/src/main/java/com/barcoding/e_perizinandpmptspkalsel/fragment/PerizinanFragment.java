package com.barcoding.e_perizinandpmptspkalsel.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.barcoding.e_perizinandpmptspkalsel.DataPemohon.TabPemohonActivity;
import com.barcoding.e_perizinandpmptspkalsel.JenisPerizinan.ListAdapterPerizinan;
import com.barcoding.e_perizinandpmptspkalsel.JenisPerizinan.TabAboutActivity;
import com.barcoding.e_perizinandpmptspkalsel.R;
import com.barcoding.e_perizinandpmptspkalsel.akun.BiodataActivity;
import com.barcoding.e_perizinandpmptspkalsel.akun.KeluhanActivity;
import com.barcoding.e_perizinandpmptspkalsel.akun.KontakActivity;
import com.barcoding.e_perizinandpmptspkalsel.akun.ListAdapterAkun;
import com.barcoding.e_perizinandpmptspkalsel.akun.SaranActivity;
import com.barcoding.e_perizinandpmptspkalsel.akun.TentangAplikasiActivity;

import java.util.ArrayList;

public class PerizinanFragment extends Fragment {

    private ArrayAdapter<String> stringArrayAdapter;
    private ArrayList<String> arrayList;
    private SearchView searchView;

    ListView lv;

    private Toolbar toolbar;

    String[] Headline = {"Izin Mendirikan Rumah Sakit Kelas B", "Izin Operasional dan Penetapan Kelas Rumah Sakit Kelas B",
            "Izin Usaha Kecil Obat Tradisonal (UKOT)", "Izin Pest Control Pengendalian Vektor dan Penyakit",
            "Izin Pengumpulan Uang atau Barang", "Izin Pengangkatan Anak Warga Negara Indonesia",
            "Izin Pendirian/Perpanjangan Kantor Cabang PPTKIS","Izin Penyelenggaraan Pemagangan ke Luar Negeri",
            "Izin Operasional Sekolah Menengah Kejuruan","Izin Operasional Sekolah Menengah Atas",
            "Izin Operasional Pendidikan Khusus", "Izin Penggunaan Arsip yang Bersifat Tertutup yang Disimpan di Lembaga Kearsipan Daerah Provinsi",
            "Izin Penggalian dan Penanaman Kabel Serat Optik untuk Jaringan Komunikasi Pada Ruas Jalan Provinsi",
            "Izin Penggalian dan Pemasangan Pipa Transmisi Air Baku PDAM Pada Ruas Jalan Provinsi",
            "Izin Penggalian dan Pemasangan Kabel Listrik Bawah Tanah (NYFGLIY) untuk keperluan Iklan/Promosi pada Ruas Jalan Provinsi",
            "Izin Penggalian dan pemasangan Kabel Listrik dan Telekomunikasi",
            "Izin Pemanfaatan Air Permukaan (SIPA) pada Wilayah Sungai yang menjadi Kewenangan Provinsi",
            "Izin Penggalian dan Penanaman Pipa Instalasi Pengelolaan Air Limbah",
            "Izin Pembelokan Sungai (khususnya pertambangan, dan lain-lain)"
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_perizinan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        toolbar = view.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Perizinan");


        lv = view.findViewById(R.id.lv_list);
        ListAdapterPerizinan listAdapterPerizinan = new ListAdapterPerizinan(getContext(), Headline);
        lv.setAdapter(listAdapterPerizinan);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(view.getContext(), TabAboutActivity.class);
                startActivityForResult(i,0);
            }
        });

        searchView = view.findViewById(R.id.searchView);

    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

}
