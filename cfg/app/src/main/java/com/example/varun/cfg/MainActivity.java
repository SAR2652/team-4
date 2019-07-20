package com.example.varun.cfg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void btnLectures(View view) {
        Log.d("cfg", "before Intent");
        Intent intent = new Intent(this,LectureListActivity.class);
        this.startActivity(intent);
    }
}
