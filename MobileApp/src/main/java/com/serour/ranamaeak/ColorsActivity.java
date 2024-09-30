package com.serour.ranamaeak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;

public class ColorsActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_colors);

            final Button red = findViewById(R.id.red);
            final Button green = findViewById(R.id.green);
            final Button blue = findViewById(R.id.blue);
            final Button orange = findViewById(R.id.orange);
            final Button yellow = findViewById(R.id.yellow);
            final Button purple = findViewById(R.id.purple);
            final Button black = findViewById(R.id.black);
            final Button white = findViewById(R.id.white);


            final MediaPlayer mp1 = MediaPlayer.create(getApplicationContext(), R.raw.red);
            final MediaPlayer mp2 = MediaPlayer.create(getApplicationContext(), R.raw.green);
            final MediaPlayer mp3 = MediaPlayer.create(getApplicationContext(), R.raw.blue);
            final MediaPlayer mp4 = MediaPlayer.create(getApplicationContext(), R.raw.orange);
            final MediaPlayer mp5 = MediaPlayer.create(getApplicationContext(), R.raw.yellow);
            final MediaPlayer mp6 = MediaPlayer.create(getApplicationContext(), R.raw.purple);


            View.OnClickListener elem = new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    switch (v.getId()) {
                        case R.id.red:
                            red.setText("أَحْمَرْ");
                            mp1.start();
                            break;
                        case R.id.green:
                            green.setText("أَخْضَرْ");
                            mp2.start();
                            break;
                        case R.id.blue:
                            blue.setText("أَزْرَقْ");
                            mp3.start();
                            break;
                        case R.id.orange:
                            orange.setText("بُرْتُقَالِي");
                            mp4.start();
                            break;
                        case R.id.yellow:
                            yellow.setText("أَصْفَرْ");
                            mp5.start();
                            break;
                        case R.id.purple:
                            purple.setText("بَنَفْسَجِي");
                            mp6.start();
                            break;
                        case R.id.black:
                            black.setText("أَسْوَدْ");
                            mp6.start();
                            break;
                        case R.id.white:
                            white.setText("أَبْيَضْ");
                            mp6.start();
                            break;

                    }
                }
            };
            red.setOnClickListener(elem);
            green.setOnClickListener(elem);
            blue.setOnClickListener(elem);
            orange.setOnClickListener(elem);
            yellow.setOnClickListener(elem);
            purple.setOnClickListener(elem);
            black.setOnClickListener(elem);
            white.setOnClickListener(elem);

        }
    }