package com.example.babymanager;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //Room Database
    static RoomDBClass roomDBClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ROOM Database
        roomDBClass = Room.databaseBuilder(getApplicationContext(), RoomDBClass.class, "mydb").allowMainThreadQueries().build();


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

        //to save all the elements on profile
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Profile Activity");

        final EditText mNameEt = findViewById(R.id.name_text);
//        final EditText mDobEt = findViewById(R.id.dob_text);
//        final Spinner mSpinner2 = findViewById(R.id.label_spinner_2);
//        final Spinner mSpinner3 = findViewById(R.id.label_spinner_3);

        Button mSaveBtn = findViewById(R.id.save_btn);

        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String name = mNameEt.getText().toString();
//                String dob = mDobEt.getText().toString();
//                String spinner_2 = mSpinner2.getTransitionName().toString();
//                String spinner_3 = mSpinner3.getTransitionName().toString();

                //activity intent
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("NAME", name);
//                intent.putExtra("DOB", dob);
//                intent.putExtra("GENDER", spinner_2);
//                intent.putExtra("PERSON", spinner_3);
                startActivity(intent);
            }
        });

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