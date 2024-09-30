package com.serour.ranamaeak;


import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AlphabetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);
        final Button alif = findViewById(R.id.alif);
        final Button ba = findViewById(R.id.ba);
        final Button ta = findViewById(R.id.ta);
        final Button tha = findViewById(R.id.tha);
        final Button jim = findViewById(R.id.jim);
        final Button ha = findViewById(R.id.ha);
        final Button kha = findViewById(R.id.kha);
        final Button dal = findViewById(R.id.dal);
        final Button thal = findViewById(R.id.thal);
        final Button ra = findViewById(R.id.ra);
        final TextView zay = findViewById(R.id.zay);
        final TextView sin = findViewById(R.id.sin);
        final TextView chin = findViewById(R.id.chin);
        final TextView sad = findViewById(R.id.sad);
        final TextView dad = findViewById(R.id.dad);
        final TextView taa = findViewById(R.id.taa);
        final TextView daa = findViewById(R.id.daa);
        final TextView ayn = findViewById(R.id.ayn);
        final TextView ghayn = findViewById(R.id.ghayn);
        final TextView fa = findViewById(R.id.fa);
        final TextView qaf = findViewById(R.id.qaf);
        final TextView kaf = findViewById(R.id.kaf);
        final TextView lam = findViewById(R.id.lam);
        final TextView mim = findViewById(R.id.mim);
        final TextView noun = findViewById(R.id.noun);
        final TextView haa = findViewById(R.id.haa);
        final TextView waw = findViewById(R.id.waw);
        final TextView ya = findViewById(R.id.ya);


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
                    case R.id.alif:
                        mp0.start();
                        break;
                    case R.id.ba:
                        mp1.start();
                        break;
                    case R.id.ta:
                        mp2.start();
                        break;
                    case R.id.tha:
                        mp3.start();
                        break;
                    case R.id.jim:
                        mp4.start();
                        break;
                    case R.id.ha:
                        mp5.start();
                        break;
                    case R.id.kha:
                        mp6.start();
                        break;
                    case R.id.dal:
                        mp7.start();
                        break;
                    case R.id.thal:
                        mp8.start();
                        break;
                    case R.id.ra:
                        mp9.start();
                        break;
                    case R.id.zay:
                        mp9.start();
                        break;
                    case R.id.sin:
                        mp9.start();
                        break;
                    case R.id.chin:
                        mp9.start();
                        break;
                    case R.id.sad:
                        mp9.start();
                        break;
                    case R.id.dad:
                        mp9.start();
                        break;
                    case R.id.taa:
                        mp9.start();
                        break;
                    case R.id.daa:
                        mp9.start();
                        break;
                    case R.id.ayn:
                        mp9.start();
                        break;
                    case R.id.ghayn:
                        mp9.start();
                        break;
                    case R.id.fa:
                        mp9.start();
                        break;
                    case R.id.qaf:
                        mp9.start();
                        break;
                    case R.id.kaf:
                        mp9.start();
                        break;
                    case R.id.lam:
                        mp9.start();
                        break;
                    case R.id.mim:
                        mp9.start();
                        break;
                    case R.id.noun:
                        mp9.start();
                        break;
                    case R.id.haa:
                        mp9.start();
                        break;
                    case R.id.waw:
                        mp9.start();
                        break;
                    case R.id.ya:
                        mp9.start();
                        break;
                }
            }
        };
        alif.setOnClickListener(elem);
        ba.setOnClickListener(elem);
        ta.setOnClickListener(elem);
        tha.setOnClickListener(elem);
        jim.setOnClickListener(elem);
        ha.setOnClickListener(elem);
        kha.setOnClickListener(elem);
        dal.setOnClickListener(elem);
        thal.setOnClickListener(elem);
        ra.setOnClickListener(elem);
        zay.setOnClickListener(elem);
        sin.setOnClickListener(elem);
        chin.setOnClickListener(elem);
        sad.setOnClickListener(elem);
        dad.setOnClickListener(elem);
        taa.setOnClickListener(elem);
        daa.setOnClickListener(elem);
        ayn.setOnClickListener(elem);
        ghayn.setOnClickListener(elem);
        fa.setOnClickListener(elem);
        qaf.setOnClickListener(elem);
        kaf.setOnClickListener(elem);
        lam.setOnClickListener(elem);
        mim.setOnClickListener(elem);
        noun.setOnClickListener(elem);
        haa.setOnClickListener(elem);
        waw.setOnClickListener(elem);
        ya.setOnClickListener(elem);


    }
}