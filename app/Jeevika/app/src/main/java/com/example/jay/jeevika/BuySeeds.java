package com.example.jay.jeevika;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class BuySeeds extends AppCompatActivity {
    private Spinner itemsToBuySpinner;
    private String itemsToBuySelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_seeds);
        itemsToBuySpinner = (Spinner) findViewById(R.id.itemsToBuySpinner);
        String[] ponds = new String[]{"1", "2", "3", "ksf", "sd" ,"sd", "sd", "sd", "sd", "sd", "sd" ,"sd" ,"ssd" ,"sd" ,"ds" ,"ds" ,"ds", "dds", "" };
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(BuySeeds.this, android.R.layout.simple_spinner_dropdown_item, ponds);
        itemsToBuySpinner.setAdapter(itemsAdapter);

        itemsToBuySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemsToBuySelected = parent.getSelectedItem().toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void itemsToBuySubmitButton(View view){
        //Intent to the next page. Form processing
        Intent startSellerListActivity =new Intent(BuySeeds.this, SellerList.class);
        startSellerListActivity.putExtra("itemsToBuySelected", itemsToBuySelected);
        startActivity(startSellerListActivity);
    }

}
