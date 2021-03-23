package com.barcoding.e_perizinandpmptspkalsel.JenisPerizinan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.barcoding.e_perizinandpmptspkalsel.DataPemohon.TabPemohonActivity;
import com.barcoding.e_perizinandpmptspkalsel.JenisPerizinan.FragmentAbout.PersyaratanFragment;
import com.barcoding.e_perizinandpmptspkalsel.JenisPerizinan.FragmentAbout.ProsedurFragment;
import com.barcoding.e_perizinandpmptspkalsel.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class TabAboutActivity extends AppCompatActivity {

    FloatingActionButton btnAction;

    private TabLayout tab;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_about);

        setTitle("Dekripsi");

        tab = findViewById(R.id.tab);
        viewPager = findViewById(R.id.view_pager);

        btnAction = findViewById(R.id.btnAction);
        btnAction.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), TabPemohonActivity.class);
            startActivity(i);
        });


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

    public void SetupViewPager() {
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new PersyaratanFragment(), "Persyaratan");
        adapter.AddFragment(new ProsedurFragment(), "Prosedur");
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
            return 2;
        }
    }
}