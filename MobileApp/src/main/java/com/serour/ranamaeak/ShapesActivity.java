package com.serour.ranamaeak;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ShapesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shapes);
        final Button circle = findViewById(R.id.button1);
        final Button square = findViewById(R.id.button2);
        final Button rectangle = findViewById(R.id.button3);
        final Button triangle = findViewById(R.id.button4);
        final Button star = findViewById(R.id.button5);
        final Button diamond = findViewById(R.id.button6);

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
                        circle.setText("دَائِرَةٌ");
                        mp1.start();
                        break;
                    case R.id.button2:
                        square.setText("مُرَبَّعٌ");
                        mp2.start();
                        break;
                    case R.id.button3:
                        rectangle.setText("مُسْتَطِيلٌ");
                        mp3.start();
                        break;
                    case R.id.button4:
                        triangle.setText("مُثَلَّثٌ");
                        mp4.start();
                        break;
                    case R.id.button5:
                        star.setText("نَجْمَةٌ");
                        mp5.start();
                        break;
                    case R.id.button6:
                        diamond.setText("مُعَيَّنٌ");
                        mp6.start();
                        break;

                }
            }
        };
        circle.setOnClickListener(elem);
        square.setOnClickListener(elem);
        rectangle.setOnClickListener(elem);
        triangle.setOnClickListener(elem);
        star.setOnClickListener(elem);
        diamond.setOnClickListener(elem);
    }
}