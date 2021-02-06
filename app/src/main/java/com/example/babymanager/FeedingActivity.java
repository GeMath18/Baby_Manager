package com.example.babymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FeedingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeding);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}