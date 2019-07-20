package com.example.jay.jeevika;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class sellFish extends AppCompatActivity {

    private EditText productToSellEditText, productQuantityEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_fish);
    }

    public void productToSellSubmitButton(View view){
        productToSellEditText = findViewById(R.id.productToSellEditText);
        productQuantityEditText = findViewById(R.id.productQuantityEditText);

        String productToSell = productToSellEditText.getText().toString();
        int productQuantity = Integer.parseInt(productQuantityEditText.getText().toString());

        Log.v("product ordered: ", "productToSell : "+ productToSell + "productQuantity: "+ productQuantity);
        Intent startSellerList =new Intent(sellFish.this, SellerList.class);
        startActivity(startSellerList);
    }
}
