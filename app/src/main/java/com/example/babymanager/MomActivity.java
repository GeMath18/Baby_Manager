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
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MomActivity extends AppCompatActivity {

    EditText start_nap_time;
    EditText end_nap_time;
    Button save_n_btn;
    RecyclerView recyclerView;

    List<NapData> dataList = new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    RoomDBNap database;
    NapAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mom);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        EditText start_nap_time = findViewById(R.id.datetime_start_nap_input);
        start_nap_time.setInputType(InputType.TYPE_NULL);

        start_nap_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateTimeDialog(start_nap_time);
            }

        });

        //To set up End time of sleep
        EditText end_nap_time = findViewById(R.id.time_end_time_input);
        end_nap_time.setInputType(InputType.TYPE_NULL);

        end_nap_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimeDialog(end_nap_time);
            }
        });

        Button save_n_btn = findViewById(R.id.save_nap_btn);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        database = RoomDBNap.getInstance(this);
        dataList = database.napDao().getAll();

        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new NapAdapter(MomActivity.this, dataList);
        recyclerView.setAdapter(adapter);

        save_n_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String startTime = start_nap_time.getText().toString();
                String stopTime = end_nap_time.getText().toString();

                NapData data = new NapData();
                data.setStart_nap(startTime);
                data.setStop_nap(stopTime);

                database.napDao().insert(data);

                start_nap_time.setText("");
                end_nap_time.setText("");

                dataList.clear();
                dataList.addAll(database.napDao().getAll());
                adapter.notifyDataSetChanged();
            }
        });


    }

    //End Time Dialog
    private void showTimeDialog(EditText end_nap_time) {
        final Calendar calendar = Calendar.getInstance();

        TimePickerDialog.OnTimeSetListener timeSetListener= new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                calendar.set(Calendar.MINUTE, minute);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("  HH:mm  ");

                end_nap_time.setText(simpleDateFormat.format(calendar.getTime()));

            }
        };

        new TimePickerDialog(MomActivity.this, timeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show();
    }

    //Start time of nap TimeDialog
    private void showDateTimeDialog(EditText start_nap_time) {

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

                        start_nap_time.setText(simpleDateFormat.format(calendar.getTime()));
//
                    }
                };

                new TimePickerDialog(MomActivity.this,timeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show();

            }
        };

        new DatePickerDialog(MomActivity.this,dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show();


    }
}