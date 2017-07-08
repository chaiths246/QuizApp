package com.example.chaithra.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class RadioButtonActivity extends AppCompatActivity {

    Button nextButton;

    TextView question1;
    RadioButton option1, option2, option3, option4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        option1 = (RadioButton) findViewById(R.id.option1);
        option2 = (RadioButton) findViewById(R.id.option2);
        option3 = (RadioButton) findViewById(R.id.option3);
        option4 = (RadioButton) findViewById(R.id.option4);

        question1 = (TextView) findViewById(R.id.question);

        nextButton = (Button) findViewById(R.id.radioButton);
        displayCurrentQuestion();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lockTheAnswers();
            }
        });
    }

    public void onOptionClicked(View view) {
        updateNextButtonStatus();
    }

    private void updateNextButtonStatus() {
        if (option1.isChecked()
                || option2.isChecked()
                || option3.isChecked()
                || option4.isChecked()) {
            nextButton.setEnabled(true);
        } else {
            nextButton.setEnabled(false);
        }
    }

    private void displayCurrentQuestion() {

        Question question = ApplicationState.INSTANCE.quizMaster.getCurrentQuestion();

        question1.setText(question.getContent());
        ArrayList<Answer> options = question.getOptions();
        option1.setText(options.get(0).getContent());
        option2.setText(options.get(1).getContent());
        option3.setText(options.get(2).getContent());
        option4.setText(options.get(3).getContent());

        option1.setChecked(false);
        option2.setChecked(false);
        option3.setChecked(false);
        option4.setChecked(false);
    }

    private void lockTheAnswers() {
        ArrayList<Answer> selectedAnswers = new ArrayList<>();
        Question currentQuestion = ApplicationState.INSTANCE.quizMaster.getCurrentQuestion();
        ArrayList<Answer> options = currentQuestion.getOptions();
        ArrayList<RadioButton> radiobutton = new ArrayList<>();
        radiobutton.add(option1);
        radiobutton.add(option2);
        radiobutton.add(option3);
        radiobutton.add(option4);

        for (int i = 0; i < radiobutton.size(); i++) {
            RadioButton radioButton = radiobutton.get(i);
            if (radioButton.isChecked()) {
                selectedAnswers.add(options.get(i));
                break;
            }
        }

        ApplicationState.INSTANCE.quizMaster.myAnswer(selectedAnswers);
        navigateToNextQuestion();

    }

    public void navigateToNextQuestion() {
        //ApplicationState.INSTANCE.quizMaster.myAnswer(answers);
        if (ApplicationState.INSTANCE.quizMaster.isLastQuestion()) {
            Intent intent1 = new Intent(RadioButtonActivity.this, ScoreActivity.class);
            startActivity(intent1);
            return;
        }

        Question question = ApplicationState.INSTANCE.quizMaster.getCurrentQuestion();
        if (question.totalCorrectAnswers() > 1) {
            Intent intent1 = new Intent(RadioButtonActivity.this, ChechBoxActivity.class);
            startActivity(intent1);
        } else if (question.totalCorrectAnswers() == 0) {
            Intent intent = new Intent(RadioButtonActivity.this, EditTextActivity.class);
            startActivity(intent);
        } else if (question.totalCorrectAnswers() == 1) {
            Intent intent2 = new Intent(RadioButtonActivity.this, RadioButtonActivity.class);
            startActivity(intent2);
        }
    }
}
