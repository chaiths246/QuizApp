package com.example.chaithra.quizapp;

import java.util.ArrayList;

/**
 * Created by chaithra on 1/21/17.
 */

public class QuizMaster {

    private final int maxAttempts = 1;
    private ArrayList<Question> questions;
    private int currentQuestion = 0;
    private int score = 0;
    private int attempt = 0;
    private String crctAnswer = "50";

    /*
    This function is used to generate the number of questions
     */
    public QuizMaster() {

        ArrayList<Answer> q1Options = new ArrayList<Answer>();
        Answer qoption11 = new Answer("Delhi");
        q1Options.add(qoption11);
        Answer qoption12 = new Answer("Hyderbad");
        q1Options.add(qoption12);
        Answer qoption13 = new Answer("Bangalore");
        q1Options.add(qoption13);
        Answer qoption14 = new Answer("Hubli");
        q1Options.add(qoption14);
        ArrayList<Answer> q1CorrectAnswers = new ArrayList<Answer>();
        q1CorrectAnswers.add(qoption11);

        Question Question1 = new Question("1.Which is the capital of india", q1Options, q1CorrectAnswers);


        ArrayList<Answer> q2Options = new ArrayList<Answer>();
        Answer qoption21 = new Answer("Washington, D.C.");
        q2Options.add(qoption21);
        Answer qoption22 = new Answer("Seattle");
        q2Options.add(qoption22);
        Answer qoption23 = new Answer("California");
        q2Options.add(qoption23);
        Answer qoption24 = new Answer("Arizona");
        q2Options.add(qoption24);
        ArrayList<Answer> q2CorrectAnswers = new ArrayList<Answer>();
        q2CorrectAnswers.add(qoption21);
        Question Question2 = new Question("2.Which is the capital of USA", q2Options, q2CorrectAnswers);

        ArrayList<Answer> q3Options = new ArrayList<Answer>();
        Answer qoption31 = new Answer("Delhi.");
        q3Options.add(qoption31);
        Answer qoption32 = new Answer("Karnataks");
        q3Options.add(qoption32);
        Answer qoption33 = new Answer("California");
        q3Options.add(qoption33);
        Answer qoption34 = new Answer("Arizona");
        q3Options.add(qoption34);
        ArrayList<Answer> q3CorrectAnswers = new ArrayList<Answer>();
        q3CorrectAnswers.add(qoption33);
        q3CorrectAnswers.add(qoption34);
        Question Question3 = new Question("3.Which are the two states that contain in the USA", q3Options, q3CorrectAnswers);


        ArrayList<Answer> q4Options = new ArrayList<Answer>();
        ArrayList<Answer> q4CorrectAnswers = new ArrayList<Answer>();
        Question Question4 = new Question("4.Number of states in USA", q4Options, q4CorrectAnswers);

        ArrayList<Answer> q5Options = new ArrayList<Answer>();
        Answer qoption51 = new Answer("Steve jobs.");
        q5Options.add(qoption51);
        Answer qoption52 = new Answer("Edison");
        q5Options.add(qoption52);
        Answer qoption53 = new Answer("Charles babage");
        q5Options.add(qoption53);
        Answer qoption54 = new Answer("Dennis Ritchie");
        q5Options.add(qoption54);
        ArrayList<Answer> q5CorrectAnswers = new ArrayList<Answer>();
        q5CorrectAnswers.add(qoption53);

        Question Question5 = new Question("5.Who is the father of the computer?", q5Options, q5CorrectAnswers);


        questions = new ArrayList<Question>();

        questions.add(Question1);
        questions.add(Question2);
        questions.add(Question3);
        questions.add(Question4);
        questions.add(Question5);


    }

    /*
    This function checks is there any next question.
     */

    public boolean isLastQuestion() {

        return (currentQuestion >= questions.size());
    }

    /*
    this function is used to get the current question.
     */
    public Question getCurrentQuestion() {
        if (currentQuestion < questions.size()) {

            return questions.get(currentQuestion);
        }
        return null;
    }

/*
This function is used to get the next question
 */

    public boolean myAnswer(ArrayList<Answer> answers) {
        Question currentQuestion = getCurrentQuestion();

        boolean isAnswerCorrect = currentQuestion.validateAnswers(answers);
        if (isAnswerCorrect) {
            advanceQuestion();
            score = score + 1;
            return true;
        } else {
            attempt++;
            if (attempt == maxAttempts) {
                advanceQuestion();
                return true;
            }
            return false;
        }
    }

    public boolean myEdittextAnswer(String crctAnswer1) {


        if (crctAnswer.equals(crctAnswer1)) {
            advanceQuestion();
            score = score + 1;
            return true;
        } else {
            attempt++;
            if (attempt == maxAttempts) {
                advanceQuestion();
                return true;
            }
            return false;
        }
    }

    public void skipCurrenQuestion() {
        advanceQuestion();
    }

    public int getCurrentScore() {
        return score;
    }

    private void advanceQuestion() {
        attempt = 0;
        currentQuestion++;
    }


    /*
    This function is used to get the total number of questions
     */
    public int totalNUmberOfQuestions() {
        return questions.size();
    }
}

