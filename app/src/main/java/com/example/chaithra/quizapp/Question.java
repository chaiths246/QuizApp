package com.example.chaithra.quizapp;

import java.util.ArrayList;

/**
 * Created by chaithra on 1/18/17.
 */

public class Question {
    private String content;
    private ArrayList<Answer> options;

    private ArrayList<Answer> correctAnswers;
    /**
     * Construtcor is used to set the question,options and correct answer
     */
    Question(String content, ArrayList<Answer> options, ArrayList<Answer> correctAnswers) {
        this.content = content;
        this.options = options;
        this.correctAnswers = correctAnswers;
    }

    public String getContent() {
        return content;
    }

    public ArrayList<Answer> getOptions() {
        return options;
    }
    
    public int totalCorrectAnswers() {

        return correctAnswers.size();
    }

    public boolean validateAnswers(ArrayList<Answer> givenAnswers) {
        if (correctAnswers.size() != givenAnswers.size()) {
            return false;
        }
        for (int i = 0; i < givenAnswers.size(); i++) {
            Answer givenAnswer = givenAnswers.get(i);
            if (!correctAnswers.contains(givenAnswer)) {
                return false;

            }
        }
        return true;
    }

    public boolean isCorrectAnswer(ArrayList<Answer> givenAnswers) {
        if (correctAnswers.contains(givenAnswers)) {
            return true;
        }
        return false;
    }
}
