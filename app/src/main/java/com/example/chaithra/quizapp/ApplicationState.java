package com.example.chaithra.quizapp;

/**
 * Created by chaithra on 6/26/17.
 */

public class ApplicationState  {
    public QuizMaster quizMaster =new QuizMaster();

    static ApplicationState INSTANCE = new ApplicationState();

    private ApplicationState() {

    }

}
