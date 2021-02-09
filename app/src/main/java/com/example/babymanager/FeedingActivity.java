package com.example.babymanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FeedingActivity extends AppCompatActivity {

    private ImageView left_label, right_label, bottle_label, meal_label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeding);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //To connect the Two Fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, new FormulafeedingFragment());
        fragmentTransaction.commit();

        ////End of lane 22-28

        //to create action for buttons to connect with fragments
        init();

        left_label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame_layout, new LeftfeedingFragment());
                ft.commit();
            }
        });

        right_label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame_layout, new RightfeedingFragment());
                ft.commit();
            }
        });

        bottle_label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame_layout, new FormulafeedingFragment());
                ft.commit();

            }
        });

        meal_label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frame_layout, new SupfeedingFragment());
                ft.commit();
            }
        });

    }

    private void init() {
        left_label = findViewById(R.id.left_label);
        right_label = findViewById(R.id.right_label);
        bottle_label = findViewById(R.id.bottle_label);
        meal_label = findViewById(R.id.meal_label);

    }
}