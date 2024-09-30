package com.serour.ranamaeak;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;

public class DirectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direction);

        final Button left = findViewById(R.id.left);
        final Button right = findViewById(R.id.right);
        final Button top = findViewById(R.id.top);
        final Button down = findViewById(R.id.down);


        final MediaPlayer mp1 = MediaPlayer.create(getApplicationContext(), R.raw.red);
        final MediaPlayer mp2 = MediaPlayer.create(getApplicationContext(), R.raw.green);
        final MediaPlayer mp3 = MediaPlayer.create(getApplicationContext(), R.raw.blue);
        final MediaPlayer mp4 = MediaPlayer.create(getApplicationContext(), R.raw.orange);


        View.OnClickListener elem = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.left:
                        left.setText("يَسَارْ");
                        mp1.start();
                        break;
                    case R.id.right:
                        right.setText("يَمِينْ");
                        mp2.start();
                        break;
                    case R.id.top:
                        top.setText("فَوْقَ");
                        mp3.start();
                        break;
                    case R.id.down:
                        down.setText("تَحْتَ");
                        mp4.start();
                        break;
                }
            }
        };
        left.setOnClickListener(elem);
        right.setOnClickListener(elem);
        top.setOnClickListener(elem);
        down.setOnClickListener(elem);


    }
}