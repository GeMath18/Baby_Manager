package com.example.babymanager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class SummaryBottleFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    RecyclerAdapter recyclerAdapter;


    public SummaryBottleFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_summary_bottle, container, false);

        //Room
        recyclerView = view.findViewById(R.id.recyclerView);


//        ArrayList<Bottle> list = new ArrayList<Bottle>();
//
//        Bottle bottle = new Bottle();
//        bottle.setDatetime("12/12/12");
//        bottle.setAmount("3");
//        bottle.setSpinner("formula");
//        list.add(bottle);


        List<Bottle> list = MainActivity.roomDBClass.bottleDao().getAll();

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdapter = new RecyclerAdapter( getActivity(), list);
        recyclerView.setAdapter(recyclerAdapter);




        //**to pass the information from EditText to ListView
//        Bundle bundle = getArguments();

//        String dateTime = bundle.getString("DateTime");
//        String amount = bundle.getString("Amount");
//        String bSpinner = bundle.getString("BSpinner");

//        TextView dateTimeText = (TextView) view.findViewById(R.id.label_1);
//        TextView amountText = (TextView) view.findViewById(R.id.label_2);
//        TextView bSpinnerText = (TextView) view.findViewById(R.id.label_3);
//
//        dateTimeText.setText(dateTime);
//        amountText.setText(amount);
//        bSpinnerText.setText(bSpinner);


//        ListView listView = (ListView) view.findViewById(R.id.summary_listView);
//        listView.setAdapter((ListAdapter) listView);



        return view;
    }
}