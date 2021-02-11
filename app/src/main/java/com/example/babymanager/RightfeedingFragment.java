package com.example.babymanager;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.SystemClock;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class RightfeedingFragment extends Fragment {

    private Chronometer chronometer;
    private long PauseOffset = 0;
    private boolean isPlaying = false;
    private ToggleButton toggleButton;
    private ImageView reset_btn;
    private Button save_l_button;

    public RightfeedingFragment() {
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
        View view = inflater.inflate(R.layout.fragment_rightfeeding, container, false);

        //To set up Chronometer
        chronometer = (Chronometer) view.findViewById(R.id.chronometer);
        toggleButton = (ToggleButton) view.findViewById(R.id.Toggle);
        reset_btn = (ImageView) view.findViewById(R.id.reset_btn);

        toggleButton.setText(null);
        toggleButton.setTextOn(null);
        toggleButton.setTextOff(null);


        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    chronometer.setBase(SystemClock.elapsedRealtime()- PauseOffset);
                    chronometer.start();
                    isPlaying = true;
                }else{
                    chronometer.stop();
                    PauseOffset = SystemClock.elapsedRealtime()- chronometer.getBase();
                    isPlaying = false;
                }
            }
        });

        // to add the reset function of out button
        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPlaying){
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    PauseOffset = 0;
                    chronometer.start();
                    isPlaying = true;
                }
            }
        });

        //date-time picker text label
        EditText date_time_in = (EditText) view.findViewById(R.id.datetime_r_label);
        date_time_in.setInputType(InputType.TYPE_NULL);

        date_time_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateTimeDialog(date_time_in);
            }

        });

        return view;
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

                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy-MM-DD HH:mm");

                        date_time_in.setText(simpleDateFormat.format(calendar.getTime()));

                    }
                };

                new TimePickerDialog(getActivity(),timeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show();

            }
        };

        new DatePickerDialog(getActivity(),dateSetListener,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show();
    }
}