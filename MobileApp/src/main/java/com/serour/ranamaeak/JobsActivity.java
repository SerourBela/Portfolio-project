package com.serour.ranamaeak;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class JobsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs);

        final Button teacher = findViewById(R.id.button1);
        final Button doctor = findViewById(R.id.button2);
        final Button engineer = findViewById(R.id.button3);
        final Button pilot = findViewById(R.id.button4);
        final Button pompier = findViewById(R.id.button5);
        final Button avocat = findViewById(R.id.button6);

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
                        teacher.setText("مُعَلِّمٌ");
                        mp1.start();
                        break;
                    case R.id.button2:
                        doctor.setText("طَبِيبٌ");
                        mp2.start();
                        break;
                    case R.id.button3:
                        engineer.setText("مُهَنْدِسٌ");
                        mp3.start();
                        break;
                    case R.id.button4:
                        pilot.setText("طَيَّارٌ");
                        mp4.start();
                        break;
                    case R.id.button5:
                        pompier.setText("إِطْفَائِيٌ");
                        mp5.start();
                        break;
                    case R.id.button6:
                        avocat.setText("مُحَامِيٌ");
                        mp6.start();
                        break;

                }
            }
        };
        teacher.setOnClickListener(elem);
        doctor.setOnClickListener(elem);
        engineer.setOnClickListener(elem);
        pilot.setOnClickListener(elem);
        pompier.setOnClickListener(elem);
        avocat.setOnClickListener(elem);
    }
}