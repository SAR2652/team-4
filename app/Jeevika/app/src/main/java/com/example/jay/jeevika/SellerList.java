package com.example.jay.jeevika;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SellerList extends AppCompatActivity {
    private TextView itemsToBuySelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_list);
    }
    @Override
    protected void onStart(){
        super.onStart();
        itemsToBuySelected = findViewById(R.id.itemsToBuySelectedText);
        itemsToBuySelected.setText(getIntent().getStringExtra("itemsToBuySelected"));
    }
}
