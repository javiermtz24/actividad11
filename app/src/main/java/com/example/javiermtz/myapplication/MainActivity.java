package com.example.javiermtz.myapplication;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVideoView = findViewById(R.id.videoview);

        MediaController controller = new MediaController(context: this);
        controller.setMediaPlayer(mVideoView);

        mVideoView.setMediaController(controller);

    }

    private void initializePlayer(){
        mVideoView.setVideoPath("https://www.ebookfronzy.com/android_book/movie.mp4");

    }

    private void releasePleyer(){ mVideoView.stopPlayback();}

    @Override
    protected void onStart(){
        super.onStart();
        initializePlayer();
    }
    @Override
    protected void onStop(){
        super.onStop();
        releasePleyer();
    }

    @Override
    protected void onPause(); {
        super.onPause();
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.n){
            mVideoView.pause();
        }
    }
}
