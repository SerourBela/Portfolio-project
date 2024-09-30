package com.serour.ranamaeak;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class LearnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        GridLayout grid = findViewById(R.id.gridcat);
        setSingleEvent(grid);
    }
    private void setSingleEvent(GridLayout mainGrid) {
        for( int i=0;i<mainGrid.getChildCount();i++) {
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (finalI == 0) {
                        Intent intent = new Intent(LearnActivity.this, AlphabetActivity.class);
                        startActivity(intent);
                    } else if (finalI == 1) {
                        Intent intent = new Intent(LearnActivity.this, NumbersActivity.class);
                        startActivity(intent);

                    } else if (finalI == 2) {
                        Intent intent = new Intent(LearnActivity.this, ShapesActivity.class);
                        startActivity(intent);

                    } else if (finalI == 3) {
                        Intent intent = new Intent(LearnActivity.this,ColorsActivity.class);
                        startActivity(intent);

                    } else if (finalI == 4) {
                        Intent intent = new Intent(LearnActivity.this, FruitsActivity.class);
                        startActivity(intent);

                    } else if (finalI == 5) {
                        Intent intent = new Intent(LearnActivity.this, AnimalsActivity.class);
                        startActivity(intent);
                    } else if (finalI == 6) {
                        Intent intent = new Intent(LearnActivity.this, DirectionActivity.class);
                        startActivity(intent);
                    }else if (finalI == 7) {
                        Intent intent = new Intent(LearnActivity.this, JobsActivity.class);
                        startActivity(intent);
                    }


                }});

        }
    }

}