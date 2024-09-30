package com.serour.ranamaeak;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);
        final Button btn0 = findViewById(R.id.zero);
        final Button btn1 = findViewById(R.id.one);
        final Button btn2 = findViewById(R.id.two);
        final Button btn3 = findViewById(R.id.three);
        final Button btn4 = findViewById(R.id.four);
        final Button btn5 = findViewById(R.id.five);
        final Button btn6 = findViewById(R.id.six);
        final Button btn7 = findViewById(R.id.saven);
        final Button btn8 = findViewById(R.id.eight);
        final Button btn9 = findViewById(R.id.nine);
        final TextView num = findViewById(R.id.num);

        final MediaPlayer mp0 = MediaPlayer.create(getApplicationContext(), R.raw.zero);
        final MediaPlayer mp1 = MediaPlayer.create(getApplicationContext(), R.raw.one);
        final MediaPlayer mp2 = MediaPlayer.create(getApplicationContext(), R.raw.two);
        final MediaPlayer mp3 = MediaPlayer.create(getApplicationContext(), R.raw.three);
        final MediaPlayer mp4 = MediaPlayer.create(getApplicationContext(), R.raw.four);
        final MediaPlayer mp5 = MediaPlayer.create(getApplicationContext(), R.raw.five);
        final MediaPlayer mp6 = MediaPlayer.create(getApplicationContext(), R.raw.six);
        final MediaPlayer mp7 = MediaPlayer.create(getApplicationContext(), R.raw.saven);
        final MediaPlayer mp8 = MediaPlayer.create(getApplicationContext(), R.raw.eight);
        final MediaPlayer mp9 = MediaPlayer.create(getApplicationContext(), R.raw.nine);


        View.OnClickListener elem = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.zero:
                        num.setText("صِفْرٌ");
                        mp0.start();
                        break;
                    case R.id.one:
                        num.setText("وَاحِدٌ");
                        mp1.start();
                        break;
                    case R.id.two:
                        num.setText("اِثْنَانِ");
                        mp2.start();
                        break;
                    case R.id.three:
                        num.setText("ثَلَاثَةٌ");
                        mp3.start();
                        break;
                    case R.id.four:
                        num.setText("أَرْبَعَةٌ");
                        mp4.start();
                        break;
                    case R.id.five:
                        num.setText("خَمْسَةٌ");
                        mp5.start();
                        break;
                    case R.id.six:
                        num.setText("سِتَّةٌ");
                        mp6.start();
                        break;
                    case R.id.saven:
                        num.setText("سَبْعَةٌ");
                        mp7.start();
                        break;
                    case R.id.eight:
                        num.setText("ثَمَانِيَةٌ");
                        mp8.start();
                        break;
                    case R.id.nine:
                        num.setText("تِسْعَةٌ");
                        mp9.start();
                        break;
                }
            }
        };
        btn0.setOnClickListener(elem);
        btn1.setOnClickListener(elem);
        btn2.setOnClickListener(elem);
        btn3.setOnClickListener(elem);
        btn4.setOnClickListener(elem);
        btn5.setOnClickListener(elem);
        btn6.setOnClickListener(elem);
        btn7.setOnClickListener(elem);
        btn8.setOnClickListener(elem);
        btn9.setOnClickListener(elem);

    }
}