package com.example.a1pete.ltrapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class jump2activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump2activity);
       //prep background image
        getWindow().setBackgroundDrawableResource(R.drawable.ubcbackground);
        //prepping return button we will use
        Button btn2 = (Button) findViewById(R.id.returnbutton);


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(jump2activity.this, MainActivity.class));
            }
        });
    }

    //playing video in tab1
    public void onButtonClick(View v) {
        VideoView videoview = (VideoView) findViewById(R.id.videoview);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video);
        videoview.setVideoURI(uri);
        videoview.start();
    }
    //stopping video in tab1
    public void stopvideo(View v){
        VideoView videoview = (VideoView) findViewById(R.id.videoview);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video);
        videoview.setVideoURI(uri);
        videoview.pause();
    }


}
