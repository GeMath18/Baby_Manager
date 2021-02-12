package com.example.babymanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DiaperingActivity extends AppCompatActivity {

    EditText date_time_in;
    Spinner spinner;
    Button save_d_btn;
    RecyclerView recyclerView;

    //Implementing List for ROOM
    List<DiaperData> dataList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    RoomDBDiaper database;
    DiaperAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diapering);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Assign variable
        EditText date_time_in = findViewById(R.id.datetime_diaper_label);
        date_time_in.setInputType(InputType.TYPE_NULL);

        date_time_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateTimeDialog(date_time_in);
            }

        });

        Button save_d_btn = findViewById(R.id.save_d_btn);
       RecyclerView recyclerView = findViewById(R.id.recycler_view);

       //Initialize database
        database = RoomDBDiaper.getInstance(this);
        dataList = database.diaperDao().getAll();

        //Initialize linear layout manager
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new DiaperAdapter(DiaperingActivity.this, dataList);
        recyclerView.setAdapter(adapter);






        Spinner spinner = findViewById(R.id.diaper_spinner);
//        if (spinner != null) {
//            spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) getActivity());
//        }
        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(DiaperingActivity.this,
                R.array.diaper_status_array, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(spinnerAdapter);
        }

        //Save button functionality
        save_d_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String dateTime = date_time_in.getText().toString();
                String bSpinner = spinner.getSelectedItem().toString();

                DiaperData data = new DiaperData();
                data.setDatetime(dateTime);
                data.setSpinner(bSpinner);

                database.diaperDao().insert(data);

                date_time_in.setText("");
                ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(DiaperingActivity.this,
                        R.array.diaper_status_array, android.R.layout.simple_spinner_item);
                spinnerAdapter.setDropDownViewResource
                        (android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(spinnerAdapter);

                dataList.clear();
                dataList.addAll(database.diaperDao().getAll());
                adapter.notifyDataSetChanged();



            }
        });
    }

    private void showDateTimeDialog(EditText date_time_in) {

        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);

                TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendar.set(Calendar.MINUTE, minute);

                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm");

                        date_time_in.setText(simpleDateFormat.format(calendar.getTime()));

                    }
                };

                new TimePickerDialog(DiaperingActivity.this,timeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show();

            }
        };

        new DatePickerDialog(DiaperingActivity.this,dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show();
    }
}