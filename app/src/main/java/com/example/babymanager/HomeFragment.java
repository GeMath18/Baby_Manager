package com.example.babymanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment

        ArrayList<Menu> arrayList = new ArrayList<>();

        arrayList.add(new Menu(R.drawable.bottleicon2, "Time to feed your baby!", "Left or right side, bottle, or supplement?"));
        arrayList.add(new Menu(R.drawable.diapericon, "Time for a diaper change!", "Dirty, wet, mixed, or dry?"));
        arrayList.add(new Menu(R.drawable.sleepicon, "Time for the baby to sleep!", "Asleep or awake?"));
        arrayList.add(new Menu(R.drawable.momimage, "Time for some self care!", "Nap, shower, eat, or bathe?"));

        ListView listView = (ListView) view.findViewById(R.id.menu_listView);

        MenuAdapter menuAdapter = new MenuAdapter(getActivity(), R.layout.list_row, arrayList);

        listView.setAdapter(menuAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(view.getContext(), FeedingActivity.class);
                    startActivity(intent);
                }

                if (position == 1) {
                    Intent intent = new Intent(view.getContext(), DiaperingActivity.class);
                    startActivity(intent);
                }

                if (position == 2) {
                    Intent intent = new Intent(view.getContext(), SleepActivity.class);
                    startActivity(intent);
                }

                if (position == 3) {
                    Intent intent = new Intent(view.getContext(), MomActivity.class);
                    startActivity(intent);
                }
            }
        });

        return view;



    }


}