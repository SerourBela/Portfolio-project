package com.serour.ranamaeak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GamesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        Button animals = findViewById(R.id.animals);
        Button colors = findViewById(R.id.colors);
        Button forms = findViewById(R.id.shapes);
        Button directions = findViewById(R.id.directions);
        Button fruits = findViewById(R.id.fruits);
        Button jobs = findViewById(R.id.jobs);
        Button memory = findViewById(R.id.memory);
        animals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent u = new Intent(GamesActivity.this, AnimalsLevels.class);
                startActivity(u);
            }
        });
        fruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent u = new Intent(GamesActivity.this, FruitsLevels.class);
                startActivity(u);
            }
        });
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent u = new Intent(GamesActivity.this, ColorsLevels.class);
                startActivity(u);
            }
        });
        directions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent u = new Intent(GamesActivity.this, DirectionsLevels.class);
                startActivity(u);
            }
        });
        forms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent u = new Intent(GamesActivity.this, FormsLevels.class);
                startActivity(u);
            }
        });
        jobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent u = new Intent(GamesActivity.this, JobLevels.class);
                startActivity(u);
            }
        });
        memory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent u = new Intent(GamesActivity.this, MemoryLevels.class);
                startActivity(u);
            }
        });
    }
}