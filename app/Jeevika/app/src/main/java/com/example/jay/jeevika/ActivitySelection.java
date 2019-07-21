package com.example.jay.jeevika;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


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
        ArrayAdapter<String> activitiesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, activities);
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

        new Thread(new Runnable() {
            @Override
            public void run() {
                OutputStream os = null;
                InputStream is = null;
                HttpURLConnection conn = null;
                try {
                    //constants
                    URL url = new URL("http://192.168.43.187/team-4/web/jaljeevika/activitylog.php?pond="
                            +pondSelected+"&activity_selected="+activitySelected);
//                    URL url = new URL("http://1870.49.5.229/Desktop/hello.php");
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("pond",pondSelected);
                    jsonObject.put("activity_selected",activitySelected);
                    String message = jsonObject.toString();
                    Log.e("JSON",message);

                    conn = (HttpURLConnection) url.openConnection();
                    conn.setReadTimeout( 10000 /*milliseconds*/ );
                    conn.setConnectTimeout( 15000 /* milliseconds */ );
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);
                    conn.setDoOutput(true);
//                    conn.setFixedLengthStreamingMode(message.getBytes().length);

                    //make some HTTP header nicety
                    conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
                    conn.setRequestProperty("X-Requested-With", "XMLHttpRequest");

                    //open
                    conn.connect();
//                    Log.e("CONN","URL: " + conn.getURL().toString());
                    Log.i("info","hjffdgfgfjgjhf");

                    //setup send
                    os = new BufferedOutputStream(conn.getOutputStream());
                    os.write(message.getBytes());
                    //clean up
                    os.flush();

                    //do somehting with response
                    is = conn.getInputStream();
                    //String contentAsString = readIt(is,len);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                    //clean up
                    try {
                        os.close();
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    conn.disconnect();
                }
            }
        }).start();

        Log.e("Success","Sent the json file");

        Intent startFormResults= new Intent(ActivitySelection.this, MainActivity.class);
        startActivity(startFormResults);

    }

}

