package com.example.chaithra.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditTextActivity extends AppCompatActivity {
    EditText crctAnswer;
    TextView question1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        crctAnswer = (EditText) findViewById(R.id.edittext);
        question1 = (TextView) findViewById(R.id.question);
        question1 = (TextView) findViewById(R.id.question);
        Button nextButton;
        nextButton = (Button) findViewById(R.id.NextButton);
        displayCurrentQuestion();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lockTheAnswers();
            }
        });
    }


    private void displayCurrentQuestion() {
        Question question = ApplicationState.INSTANCE.quizMaster.getCurrentQuestion();

        question1.setText(question.getContent());
    }

    private void lockTheAnswers() {
        String TypedAnswer = crctAnswer.getText().toString();

        ApplicationState.INSTANCE.quizMaster.myEdittextAnswer(TypedAnswer);
        navigateToNextQuestion();
    }

    public void navigateToNextQuestion() {
        if (ApplicationState.INSTANCE.quizMaster.isLastQuestion()) {
            Intent intent1 = new Intent(EditTextActivity.this, ScoreActivity.class);
            startActivity(intent1);
            return;
        }

        Question question = ApplicationState.INSTANCE.quizMaster.getCurrentQuestion();
        if (question.totalCorrectAnswers() > 1) {
            Intent intent1 = new Intent(EditTextActivity.this, ChechBoxActivity.class);
            startActivity(intent1);
        } else if (question.totalCorrectAnswers() == 0) {
            Intent intent = new Intent(EditTextActivity.this, EditTextActivity.class);
            startActivity(intent);
        } else if (question.totalCorrectAnswers() == 1) {
            Intent intent2 = new Intent(EditTextActivity.this, RadioButtonActivity.class);
            startActivity(intent2);
        }
    }

}
