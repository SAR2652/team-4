package com.example.jay.jeevika;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RatingBar;

public class FormResults extends AppCompatActivity {
    private RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_results);
    }

    @Override
    protected void onStart(){
        super.onStart();
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
    }

    public void ratingSubmitButton(View view ){
        float rating = (float) ratingBar.getRating();
        Log.v("rating", Float.toString(rating));
//        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){
//            @Override
//            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
//                float rating = (float) ratingBar.getRating();
//                Log.v("rating", Float.toString(rating));
//            }
//        });
    }
}
