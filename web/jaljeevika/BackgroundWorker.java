package com.example.varun.prvlg;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundWorker extends AsyncTask <String, Void, String> {

    Activity activity;
    TextView textView;
    ImageView imageView;
    Button acceptButton;
    //Button reportButton;

    BackgroundWorker (Activity atv) {
        activity = atv;
    }

    @Override
    protected String doInBackground(String... voids) {

        String type = voids[0];

        String verifyURL = "http://192.168.43.218/prvlgApp/verify.php";
        //String verifyURL = "http://stackoverflow.com";
        if (type.equals("verify")) {
            try {

                String mem_id = voids[1];
                String mem_name = voids[2];

                URL url = new URL(verifyURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                //Log.d("abcdef", "BackgrounsdfdStart"+memberInfo);

                OutputStream outputStream = httpURLConnection.getOutputStream();

                //Log.d("abcdef", "Background"+memberInfo);

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String postData = URLEncoder.encode("mem_id","UTF-8")+"="+URLEncoder.encode(mem_id,"UTF-8")+"&"+ URLEncoder.encode("mem_name","UTF-8")+"="+URLEncoder.encode(mem_name,"UTF-8");



                //String postData = URLEncoder.encode("mem_id","UTF-8")+"="+URLEncoder.encode(memberInfo,"UTF-8");
                bufferedWriter.write(postData);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                Log.d("hi", "doInBackground: fetched");
                return result;

            } catch (Exception e) {
                Log.d("http not connected", e.getMessage(), e);
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String aVoid) {

        String f_name="", l_name="", contact="";
        if (aVoid!=null)
        {
            if (aVoid.equals("not a member")) {
                textView.setText(aVoid);
                imageView.setImageBitmap(null);
                acceptButton.setVisibility(View.INVISIBLE);
                //reportButton.setVisibility(View.INVISIBLE);

            } else {

                int i = 0;
                for (i = 0; i < aVoid.length(); i++) {
                    if (aVoid.charAt(i) == '|') {
                        f_name = aVoid.substring(0, i);
                        aVoid = aVoid.substring(i + 1);
                        break;
                    }
                }
                //String info = aVoid;
                for (i = 0; i < aVoid.length(); i++) {
                    if (aVoid.charAt(i) == '|') {
                        l_name = aVoid.substring(0, i);
                        aVoid = aVoid.substring(i + 1);
                        break;
                    }
                }

                for (i = 0; i < aVoid.length(); i++) {
                    if (aVoid.charAt(i) == '|') {
                        contact = aVoid.substring(0, i);
                        aVoid = aVoid.substring(i + 1);
                        break;
                    }
                }

                String info = "\nFirst Name: " + f_name + "\n\nLast Name: " + l_name + "\n\nContact: " + contact + "\n\nImage:\n";

                String imageString = aVoid;
                byte[] imageBytes = Base64.decode(imageString, Base64.DEFAULT);
                Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);

                textView.setText(info);
                imageView.setImageBitmap(decodedImage);
                acceptButton.setVisibility(View.VISIBLE);
                //reportButton.setVisibility(View.VISIBLE);
            }

        }
        else {
            Log.d("tag", "error in post execute");
        }

        //alertDialog.setMessage(aVoid);
        //alertDialog.show();
    }

    @Override
    protected void onPreExecute() {
        //alertDialog = new AlertDialog.Builder(context).create();
        //alertDialog.setTitle("Verification Status");

        textView = (TextView) activity.findViewById(R.id.info);
        imageView = (ImageView) activity.findViewById(R.id.image);
        acceptButton = (Button) activity.findViewById(R.id.acceptButton);
        //reportButton = (Button) activity.findViewById(R.id.reportButton);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
