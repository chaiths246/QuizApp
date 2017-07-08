package com.example.chaithra.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class ChechBoxActivity extends AppCompatActivity {
    CheckBox option1, option2, option3, option4;
    TextView question1;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chech_box);
        option1 = (CheckBox) findViewById(R.id.option1);
        option2 = (CheckBox) findViewById(R.id.option2);
        option3 = (CheckBox) findViewById(R.id.option3);
        option4 = (CheckBox) findViewById(R.id.option4);

        question1 = (TextView) findViewById(R.id.question);

        nextButton = (Button) findViewById(R.id.NextButton);
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
        updateNextButtonStatus();
    }

    private void lockTheAnswers() {
        ArrayList<Answer> selectedAnswers = new ArrayList<>();
        Question currentQuestion = ApplicationState.INSTANCE.quizMaster.getCurrentQuestion();
        ArrayList<Answer> options = currentQuestion.getOptions();
        ArrayList<CheckBox> checkBoxes = new ArrayList<>();
        checkBoxes.add(option1);
        checkBoxes.add(option2);
        checkBoxes.add(option3);
        checkBoxes.add(option4);

        for (int i = 0; i < checkBoxes.size(); i++) {
            CheckBox checkBox = checkBoxes.get(i);
            if (checkBox.isChecked()) {
                selectedAnswers.add(options.get(i));
            }
        }

        ApplicationState.INSTANCE.quizMaster.myAnswer(selectedAnswers);
        navigateToNextQuestion();

    }


    public void navigateToNextQuestion() {
        //ApplicationState.INSTANCE.quizMaster.myAnswer(answers);
        if (ApplicationState.INSTANCE.quizMaster.isLastQuestion()) {
            Intent intent1 = new Intent(ChechBoxActivity.this, ScoreActivity.class);
            startActivity(intent1);
            return;
        }

        Question question = ApplicationState.INSTANCE.quizMaster.getCurrentQuestion();
        if (question.totalCorrectAnswers() > 1) {
            Intent intent1 = new Intent(ChechBoxActivity.this, ChechBoxActivity.class);
            startActivity(intent1);
        } else if (question.totalCorrectAnswers() == 0) {
            Intent intent = new Intent(ChechBoxActivity.this, EditTextActivity.class);
            startActivity(intent);
        } else if (question.totalCorrectAnswers() == 1) {
            Intent intent2 = new Intent(ChechBoxActivity.this, RadioButtonActivity.class);
            startActivity(intent2);
        }
    }


}
