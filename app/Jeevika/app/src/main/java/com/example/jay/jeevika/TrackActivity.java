package com.example.jay.jeevika;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.text.Normalizer;

public class TrackActivity extends AppCompatActivity {

    ListView formslistView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);

        formslistView=(ListView)findViewById(R.id.forms_list);
        String[] values=new String[]{"Sowing","Harvesting","Manuring","Feeding","Grown"};

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,
                R.layout.forms_list_items,R.id.forms_list_text_view,values);

        formslistView.setAdapter(adapter);

        formslistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) formslistView.getItemAtPosition(position);

                // Show Alert
//                Toast.makeText(getApplicationContext(),
//                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
//                        .show();

                Intent startFormResults= new Intent(TrackActivity.this, FormResults.class);
                startActivity(startFormResults);

            }

        });

    }
}
