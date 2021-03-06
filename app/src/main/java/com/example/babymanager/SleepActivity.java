package com.example.babymanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SleepActivity extends AppCompatActivity {

    EditText date_start_time;
    EditText end_time;
    Button save_s_btn;
    RecyclerView recyclerView;

    List<SleepData> dataList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    RoomDBSleep database;
    SleepAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //To set up Start time of sleep
        EditText date_start_time = findViewById(R.id.datetime_start_input);
        date_start_time.setInputType(InputType.TYPE_NULL);

        date_start_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateTimeDialog(date_start_time);
            }

        });

        //To set up End time of sleep
        EditText end_time = findViewById(R.id.time_end_input);
        end_time.setInputType(InputType.TYPE_NULL);

        end_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimeDialog(end_time);
            }
        });

        Button save_s_btn = findViewById(R.id.save_sleep_btn);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        //Initialize database
        database = RoomDBSleep.getInstance(this);
        dataList = database.sleepDao().getAll();

        //Initialize linear layout manager
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new SleepAdapter(SleepActivity.this, dataList);
        recyclerView.setAdapter(adapter);

        save_s_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String startTime = date_start_time.getText().toString();
                String stopTime = end_time.getText().toString();

                SleepData data = new SleepData();
                data.setStart_time(startTime);
                data.setStop_time(stopTime);

                database.sleepDao().insert(data);

                date_start_time.setText("");
                end_time.setText("");

                dataList.clear();
                dataList.addAll(database.sleepDao().getAll());
                adapter.notifyDataSetChanged();


            }
        });


    }

    //End Time Dialog
    private void showTimeDialog(EditText end_time) {
        final Calendar calendar = Calendar.getInstance();

        TimePickerDialog.OnTimeSetListener timeSetListener= new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                calendar.set(Calendar.MINUTE, minute);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("  HH:mm  ");

                end_time.setText(simpleDateFormat.format(calendar.getTime()));

            }
        };

        new TimePickerDialog(SleepActivity.this, timeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show();
    }


    //Start time TimeDialog
    private void showDateTimeDialog(EditText date_start_time) {

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

                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-dd   HH:mm");

                        date_start_time.setText(simpleDateFormat.format(calendar.getTime()));
//
                    }
                };

                new TimePickerDialog(SleepActivity.this,timeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show();

            }
        };

        new DatePickerDialog(SleepActivity.this,dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show();
    }



}