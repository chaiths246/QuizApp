package com.example.chaithra.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    TextView mScore, newMarks;

    /*
    New activity to update the score and total number of questions.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        mScore = (TextView) findViewById(R.id.Score);
        newMarks = (TextView) findViewById(R.id.actualScore);
        QuizMaster quizMaster = new QuizMaster();
        int numberOfQuestions = quizMaster.totalNUmberOfQuestions();
        mScore.setText("  " + numberOfQuestions);
        newMarks.setText("" + ApplicationState.INSTANCE.quizMaster.getCurrentScore());

    }
}
