package com.example.jay.jeevika;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class SellerList extends AppCompatActivity {
    private TextView itemsToBuySelected;
    ListView itemsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_list);

        ArrayList<Fish> fishForm = new ArrayList<Fish>();
        fishForm.add(new Fish("ABC", "928e68673476", "Rs.80", "5", "6km"));
        fishForm.add(new Fish("ABC", "928e68673476", "Rs.80", "5", "6km"));
        fishForm.add(new Fish("ABC", "928e68673476", "Rs.80", "5", "6km"));
        fishForm.add(new Fish("ABC", "928e68673476", "Rs.80", "5", "6km"));
        fishForm.add(new Fish("ABC", "928e68673476", "Rs.80", "5", "6km"));
        fishForm.add(new Fish("ABC", "928e68673476", "Rs.80", "5", "6km"));
        fishForm.add(new Fish("ABC", "928e68673476", "Rs.80", "5", "6km"));
        fishForm.add(new Fish("ABC", "928e68673476", "Rs.80", "5", "6km"));
        fishForm.add(new Fish("ABC", "928e68673476", "Rs.80", "5", "6km"));
        fishForm.add(new Fish("ABC", "928e68673476", "Rs.80", "5", "6km"));
        fishForm.add(new Fish("ABC", "928e68673476", "Rs.80", "5", "6km"));
        fishForm.add(new Fish("ABC", "928e68673476", "Rs.80", "5", "6km"));
        fishForm.add(new Fish("ABC", "928e68673476", "Rs.80", "5", "6km"));
        fishForm.add(new Fish("ABC", "928e68673476", "Rs.80", "5", "6km"));
        fishForm.add(new Fish("ABC", "928e68673476", "Rs.80", "5", "6km"));
       FishAdapter fishAdapter = new FishAdapter(this, fishForm);
        itemsListView=(ListView)findViewById(R.id.forms_list);
        itemsListView.setAdapter(fishAdapter);



    }
//    @Override
//    protected void onStart(){
//        super.onStart();
//        itemsToBuySelected = findViewById(R.id.itemsToBuySelectedText);
//        itemsToBuySelected.setText(getIntent().getStringExtra("itemsToBuySelected"));
//    }
}
