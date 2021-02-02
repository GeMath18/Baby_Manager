package com.example.babymanager;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

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

    }
}