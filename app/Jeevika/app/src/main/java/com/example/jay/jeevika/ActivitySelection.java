package com.example.jay.jeevika;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;



public class ActivitySelection extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private TextView activity1Text;
    private Spinner pondSpinner;
    private Button submitInputDataButton;
    private String pondSelected , activitySelected;
    private Spinner activity1Spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        activity1Text = findViewById(R.id.activity1Text);
        pondSpinner = (Spinner) findViewById(R.id.Spinner1);
        submitInputDataButton = findViewById(R.id.submitInputDataButton);
        activity1Spinner = findViewById(R.id.activity1Spinner);


        String[] ponds = new String[]{"1", "2", "3"};
        ArrayAdapter<String> pondAdapter = new ArrayAdapter<String>(ActivitySelection.this, android.R.layout.simple_spinner_dropdown_item, ponds);
        pondSpinner.setAdapter(pondAdapter);
        String[] activities = new String[] {"sow", "harvest"};
        ArrayAdapter<String> activitiesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ponds);
        activity1Spinner.setAdapter(activitiesAdapter);

        pondSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pondSelected = parent.getSelectedItem().toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        activity1Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                activitySelected = parent.getSelectedItem().toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }



    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {

    }

    public void onNothingSelected(AdapterView<?> parent) {

    }
    //onclick for submit button
    public void submitInputDataButton(View view){

        Log.v("submit", "submit sucessful, pond: "+ pondSelected + "activity" + activitySelected);


    }

}

