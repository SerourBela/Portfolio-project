package com.serour.ranamaeak;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AnimalsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);
        final Button rabbit = findViewById(R.id.button1);
        final Button bear = findViewById(R.id.button2);
        final Button lion = findViewById(R.id.button3);
        final Button elephant = findViewById(R.id.button4);
        final Button dolphin = findViewById(R.id.button5);
        final Button tortoise = findViewById(R.id.button6);

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
                        rabbit.setText("أَرْنَبٌ");
                        mp1.start();
                        break;
                    case R.id.button2:
                        bear.setText("دُبٌ");
                        mp2.start();
                        break;
                    case R.id.button3:
                        lion.setText("أَسَدٌ");
                        mp3.start();
                        break;
                    case R.id.button4:
                        elephant.setText("فِيلٌ");
                        mp4.start();
                        break;
                    case R.id.button5:
                        dolphin.setText("دُلْفِينٌ");
                        mp5.start();
                        break;
                    case R.id.button6:
                        tortoise.setText("سُلَحْفَاةٌ");
                        mp6.start();
                        break;
                }
            }
        };
        rabbit.setOnClickListener(elem);
        bear.setOnClickListener(elem);
        lion.setOnClickListener(elem);
        elephant.setOnClickListener(elem);
        dolphin.setOnClickListener(elem);
        tortoise.setOnClickListener(elem);
    }
}