package com.example.babymanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.label_spinner_2);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

        ////Another Spinner
        Spinner spinner_2 = findViewById(R.id.label_spinner_3);
        if (spinner_2 != null) {
            spinner_2.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter_2 = ArrayAdapter.createFromResource(this,
                R.array.persons_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner.
        if (spinner_2 != null) {
            spinner_2.setAdapter(adapter_2);
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String spinnerLabel = parent.getItemAtPosition(position).toString();
//        displayToast(spinnerLabel);
    }
        @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}