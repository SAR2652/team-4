package com.example.varun.cfg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class LectureListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    List<LectureItem> listItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_list);


        recyclerView = (RecyclerView) findViewById(R.id.furniture_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        listItems = new ArrayList<>();

        loadLocal();
    }



    public String loadJSONFromAsset() {
        String json = null;
        Log.d("localCheck", "loadJSONFromAsset: ");
        try {
            InputStream is = this.getAssets().open("jsonData.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        //Log.d("localCheck", json.toString());
        return json;
    }


    private void loadLocal() {

        try {
            JSONObject jsonObject = new JSONObject(loadJSONFromAsset());
            JSONArray jsonArray = jsonObject.getJSONArray("furniture");
            String s = String.valueOf(jsonArray.length());
            Log.d("localCheck", s);


            for (int i = 0; i<jsonArray.length();i++) {

                JSONObject o = jsonArray.getJSONObject(i);

                Log.d("localCheck", o.toString());

                LectureItem item = new LectureItem(
                        o.getString("videoUrl"),
                        o.getString("audioUrl"),
                        o.getString("pdfUrl"),
                        o.getString("arUrl"),
                        o.getString("tagText"),
                        o.getString("id"),
                        o.getString("desc"),
                        o.getString("img")
                );
                //Log.d("localCheck", jsonArray.toString());
                listItems.add(item);

            }

            Log.d("localCheck", s);
            adapter = new MyAdapter(listItems,getApplicationContext());

            recyclerView.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
