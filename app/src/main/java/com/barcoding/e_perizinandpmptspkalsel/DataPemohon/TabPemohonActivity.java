package com.barcoding.e_perizinandpmptspkalsel.DataPemohon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.barcoding.e_perizinandpmptspkalsel.DataPemohon.FragmentPemohon.PemohonFragment;
import com.barcoding.e_perizinandpmptspkalsel.DataPemohon.FragmentPemohon.PermohonanFragment;
import com.barcoding.e_perizinandpmptspkalsel.DataPemohon.FragmentPemohon.SyaratFragment;
import com.barcoding.e_perizinandpmptspkalsel.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class TabPemohonActivity extends AppCompatActivity {

    private TabLayout tab;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_pemohon);

        setTitle("Permohonan");

        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.view_pager);

        tab.setupWithViewPager(viewPager);
        SetupViewPager();
        tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void SetupViewPager() {
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new PemohonFragment(), "Pemohon");
        adapter.AddFragment(new PermohonanFragment(), "Permohonan");
        adapter.AddFragment(new SyaratFragment(), "Persyaratan");
        viewPager.setAdapter(adapter);
    }

    private class MyViewPagerAdapter extends FragmentPagerAdapter {
        private List<Fragment> fr = new ArrayList<>();
        private List<String> title = new ArrayList<>();
        public MyViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        public void AddFragment(Fragment fragment, String jd) {
            fr.add(fragment);
            this.title.add(jd);
        }

        @Override
        public Fragment getItem(int position){
            return fr.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position){
            return title.get(position);
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Memanggil/Memasang menu item pada toolbar dari layout menu_bar.xml
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_navigation, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Membuat event/kejadian saat salah satu item pada toolbar di klik
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.send :
                //Kode disini akan di eksekusi saat tombol search di klik
                Toast.makeText(this, "Silakan Cari Sesuatu", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}