package com.example.varun.cfg;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.io.IOException;

public class LectureDetailsAactivity extends YouTubeBaseActivity {


    YouTubePlayerView YtPlayer;
    Button play;
    YouTubePlayer.OnInitializedListener YtListener;

    MediaPlayer mediaPlayer;

    String imageUrl,heading,desc,arUrl,videoUrl,audioUrl,pdfUrl,tagText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        getIntentData();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_details_aactivity);

        play = (Button) findViewById(R.id.play);
        YtPlayer = (YouTubePlayerView) findViewById(R.id.view);

        YtListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("nafty5ajgQs");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };



    }

    private void getIntentData() {

        imageUrl = getIntent().getStringExtra("image");
        heading = getIntent().getStringExtra("heading");
        desc = getIntent().getStringExtra("desc");
        arUrl = getIntent().getStringExtra("ar");
        videoUrl = getIntent().getStringExtra("video");
        audioUrl = getIntent().getStringExtra("audio");
        pdfUrl = getIntent().getStringExtra("pdf");
        tagText = getIntent().getStringExtra("tag");


    }

    public void btnPlay(View view) {
        YtPlayer.initialize(YoutubeConfig.getApiKey(),YtListener);
    }

    public void btnAudio(View view) {
        Log.d("testcfg", "btnAudio: ");
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource("http://192.168.43.218/boh.mp3");
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });
            mediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void btnPdf(View view) {
    }

    public void btnAr(View view) {

//        float f = (float) 1.0;
        Intent intent = new Intent(this,ArActivity2.class);
        intent.putExtra("arSource",arUrl);
        intent.putExtra("arSize","1.0");
        this.startActivity(intent);

    }
}
