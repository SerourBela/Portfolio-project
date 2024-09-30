package com.serour.ranamaeak;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Level3Jobs extends AppCompatActivity {

    private TextView countLabel;
    private ImageView questionImage;
    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;
    private Button answerBtn4;

    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String quizData[][] = {
            // {"Image Name", "Right Answer", "Choice1", "Choice2", "Choice3"}
            {"bear", "دُبٌ", "أَسَدٌ", "أَرْنَبٌ", "فِيلٌ"},
            {"lion", "أَسَدٌ", "سُلَحْفَاةٌ", "سِنْجابٌ", "فِيلٌ"},
            {"dog", "كَلْبٌ", "أَرْنَبٌ", "قِطٌ", "فِيلٌ"},
            {"cat", "قِطٌ", "سِنْجابٌ", "فِيلٌ", "عُصْفُورٌ"},
            {"rabbit", "أَرْنَبٌ", "سُلَحْفَاةٌ", "فِيلٌ", "عُصْفُورٌ"},
            {"tortoise", "سُلَحْفَاةٌ", "سِنْجابٌ", "فِيلٌ", "دُلْفِينٌ"},
            {"sinjab", "سِنْجابٌ", "دُلْفِينٌ", "فِيلٌ", "عُصْفُورٌ"},
            {"elephant", "فِيلٌ", "دُلْفِينٌ", "سِنْجابٌ", "قِطٌ"},
            {"oiseau", "عُصْفُورٌ", "أَرْنَبٌ", "أَسَدٌ", "قِطٌ"},
            {"dolphin", "دُلْفِينٌ", "أَسَدٌ", "فِيلٌ", "أَرْنَبٌ"},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3_jobs);

        countLabel = findViewById(R.id.countLabel);
        questionImage = findViewById(R.id.questionImage);
        answerBtn1 = findViewById(R.id.answerBtn1);
        answerBtn2 = findViewById(R.id.answerBtn2);
        answerBtn3 = findViewById(R.id.answerBtn3);
        answerBtn4 = findViewById(R.id.answerBtn4);

        // Create quizArray from quizData.
        for (int i = 0; i < quizData.length; i++) {
            // Prepare array.
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]); // Image Name
            tmpArray.add(quizData[i][1]); // Right Answer
            tmpArray.add(quizData[i][2]); // Choice1
            tmpArray.add(quizData[i][3]); // Choice2
            tmpArray.add(quizData[i][4]); // Choice3

            // Add tmpArray to quizArray.
            quizArray.add(tmpArray);
        }

        showNextQuiz();
    }

    public void showNextQuiz() {

        // Update quizCountLabel.
        countLabel.setText("السُؤَالْ " + quizCount+" :");

        // Generate random number between 0 and 4 (quizArray's size -1)
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        // Pick one quiz set.
        ArrayList<String> quiz = quizArray.get(randomNum);

        // Set Image and Right Answer.
        // Array format: {"Image Name", "Right Answer", "Choice1", "Choice2", "Choice3"}
        questionImage.setImageResource(
                getResources().getIdentifier(quiz.get(0), "drawable", getPackageName()));
        rightAnswer = quiz.get(1);

        // Remove "Image Name" from quiz and shuffle choices.
        quiz.remove(0);
        Collections.shuffle(quiz);

        // Set choices.
        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));
        answerBtn4.setText(quiz.get(3));

        // Remove this quiz from quizArray.
        quizArray.remove(randomNum);

    }

    public void checkAnswer(View view) {
        final MediaPlayer mp1 = MediaPlayer.create(getApplicationContext(), R.raw.good);
        final MediaPlayer mp2 = MediaPlayer.create(getApplicationContext(), R.raw.wrong);
        // Get pushed button.
        Button answerBtn = findViewById(view.getId());
        String btnText = answerBtn.getText().toString();
        String alertTitle;
        if (btnText.equals(rightAnswer)) {
            // Correct!!
            alertTitle = "ممتاز *-*";
            mp1.start();
            rightAnswerCount++;

        } else {
            // Wrong
            alertTitle = "خاطئ..." ;
            mp2.start();
        }
        // Create Dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("الإجابة : " + rightAnswer);
        builder.setPositiveButton("التالي", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (quizArray.size() < 1) {
                    // quizArray is empty.
                    showResult();

                } else {
                    quizCount++;
                    showNextQuiz();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    public void showResult() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("النتيجة");
        builder.setMessage(rightAnswerCount + " / 10");
        builder.setPositiveButton("حاول مرة أخرى", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                recreate();
            }
        });
        builder.setNegativeButton("حفظ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.show();
    }
}
