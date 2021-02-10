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


public class SummaryBottleFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;


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
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

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