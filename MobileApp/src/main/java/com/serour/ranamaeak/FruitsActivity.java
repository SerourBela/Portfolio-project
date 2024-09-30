package com.serour.ranamaeak;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FruitsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);

        final Button apple = findViewById(R.id.button1);
        final Button orange = findViewById(R.id.button2);
        final Button cherries = findViewById(R.id.button3);
        final Button strawberries = findViewById(R.id.button4);
        final Button mango = findViewById(R.id.button5);
        final Button batikh = findViewById(R.id.button6);

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
                    case R.id.button1:
                        mp1.start();
                        break;
                    case R.id.button2:
                        mp2.start();
                        break;
                    case R.id.button3:
                        mp3.start();
                        break;
                    case R.id.button4:
                        mp4.start();
                        break;
                    case R.id.button5:
                        mp5.start();
                        break;
                    case R.id.button6:
                        mp6.start();
                        break;

                }
            }
        };
        apple.setOnClickListener(elem);
        orange.setOnClickListener(elem);
        cherries.setOnClickListener(elem);
        strawberries.setOnClickListener(elem);
        mango.setOnClickListener(elem);
        batikh.setOnClickListener(elem);
    }
}
