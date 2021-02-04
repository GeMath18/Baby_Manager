package com.example.babymanager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;


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

        arrayList.add(new Menu(R.drawable.bottleicon2, "Days ago", "Activity"));
        arrayList.add(new Menu(R.drawable.diapericon, "Days ago", "Activity"));
        arrayList.add(new Menu(R.drawable.sleepicon, "Days ago", "Activity"));
        arrayList.add(new Menu(R.drawable.momimage, "Days ago", "Activity"));

        ListView listView = (ListView) view.findViewById(R.id.listView);

        ArrayAdapter<ArrayList> listViewAdapter = new ArrayAdapter<ArrayList>(getActivity(), android.R.layout.simple_list_item_1, Collections.singletonList(arrayList));

        listView.setAdapter(listViewAdapter);
        return view;



    }


}