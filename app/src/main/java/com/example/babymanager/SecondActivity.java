package com.example.babymanager;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //To get data from main activity
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Second Activity");

        Intent intent = getIntent();
        String name = intent.getStringExtra("NAME");
//        String dob = intent.getStringExtra("DOB");
//        String spinner_2 = intent.getStringExtra("GENDER");
//        String spinner_3 = intent.getStringExtra("PERSON");

        TextView mResult = findViewById(R.id.name_saved);

        mResult.setText(name);

        //To Create TabLayout
        TabLayout tabLayout = findViewById(R.id.tabBar);
        TabItem tabHome = findViewById(R.id.tabHome);
        TabItem tabCalendar = findViewById(R.id.tabCalendar);
        TabItem tabGraph = findViewById(R.id.tabGraph);
        ViewPager viewPager = findViewById(R.id.viewPager);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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
}