package com.example.kiddy_kids;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class aboutus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        VideoView videoView = findViewById(R.id.vedio);
        String vediopath = "android.resource://" +getPackageName() +"/" + R.raw.vedio;
        Uri uri = Uri.parse(vediopath);
        videoView.setVideoURI(uri);


        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
    }
}