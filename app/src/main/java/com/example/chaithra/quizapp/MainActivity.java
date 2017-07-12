package com.example.chaithra.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Question question = ApplicationState.INSTANCE.quizMaster.getCurrentQuestion();
        if (question.totalCorrectAnswers() > 1) {
            Intent intent1 = new Intent(MainActivity.this, ChechBoxActivity.class);
            startActivity(intent1);
        } else if (question.totalCorrectAnswers() == 0) {
            Intent intent = new Intent(MainActivity.this, EditTextActivity.class);
            startActivity(intent);
        } else if (question.totalCorrectAnswers() == 1) {
            Intent intent2 = new Intent(MainActivity.this, RadioButtonActivity.class);
            startActivity(intent2);
        }


    }
}