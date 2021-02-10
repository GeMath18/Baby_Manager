package com.example.babymanager;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class FormulafeedingFragment extends Fragment {

    EditText date_time_in;
    EditText amountOz;
    Spinner spinner;
    Button saveBtn;

    public FormulafeedingFragment() {
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
        View view = inflater.inflate(R.layout.fragment_formulafeeding, container, false);

        //date-time picker text label
        EditText date_time_in = (EditText) view.findViewById(R.id.datetime_label);
        date_time_in.setInputType(InputType.TYPE_NULL);

        date_time_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateTimeDialog(date_time_in);
            }
            
        });

        //To Add Bottle options Spinner
        Spinner spinner = (Spinner) view.findViewById(R.id.bottle_spinner);
//        if (spinner != null) {
//            spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) getActivity());
//        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.bottle_type_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

        //****To save Data to send to other Fragment****
        EditText amountOz = (EditText) view.findViewById(R.id.amountq_label);
//        Spinner bottleSpinner = (Spinner) view.findViewById(R.id.bottle_spinner);
        Button saveBtn = (Button) view.findViewById(R.id.save_bottle_button);




        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String dateTime = date_time_in.getText().toString();
                String amount = amountOz.getText().toString();
                String bSpinner = spinner.getSelectedItem().toString();

//                Bundle bundle = new Bundle();
//                bundle.putString("DateTime", dateTime);
//                bundle.putString("Amount", amount);
//                bundle.putString("BSpinner", bSpinner);

                //For Room
                Bottle bottle = new Bottle();
                bottle.setAmount(amount);
                bottle.setDatetime(dateTime);
                bottle.setSpinner(bSpinner);


                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                SummaryBottleFragment summaryBottleFragment = new SummaryBottleFragment();
//                summaryBottleFragment.setArguments(bundle);

                fragmentTransaction.replace(R.id.summary_frame_layout, summaryBottleFragment);
                fragmentTransaction.commit();

                //ROOM
                FeedingActivity.roomDBClass.bottleDao().insert(bottle);
                date_time_in.setText("");
                amountOz.setText("");
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                        R.array.bottle_type_array, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource
                        (android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);

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