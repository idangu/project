package com.example.myapplication;

import static android.provider.Settings.System.getString;

import android.content.Context;
import android.content.res.Resources;

public class QuestionLibrary {
    private String mQuestions[] = {
            getStringFromRecourse(R.string.appleQuest),
            getStringFromRecourse(R.string.orangeQuest),
            getStringFromRecourse(R.string.avocadoQuest),
            getStringFromRecourse(R.string.cherryQuest),
            getStringFromRecourse(R.string.pearQuest),
            getStringFromRecourse(R.string.bananaQuest),
            getStringFromRecourse(R.string.dogQuest),
            getStringFromRecourse(R.string.catQuest),
            getStringFromRecourse(R.string.fishQuest),
            getStringFromRecourse(R.string.cowQuest),
            getStringFromRecourse(R.string.pigQuest),
            getStringFromRecourse(R.string.bumblebeeQuest),
            getStringFromRecourse(R.string.chefQuest),
            getStringFromRecourse(R.string.nannyQuest),
            getStringFromRecourse(R.string.nurseQuest),
            getStringFromRecourse(R.string.policeQuest),
            getStringFromRecourse(R.string.serviceQuest),
            getStringFromRecourse(R.string.studentQuest),
    };

    private int numOfQuestions = mQuestions.length;

    private String getStringFromRecourse(int resId){
        return App.getContext().getResources().getString(resId);
    }

    private String mChoices[][] = {
            {getStringFromRecourse(R.string.appleA),getStringFromRecourse(R.string.appleB),getStringFromRecourse(R.string.appleC)},
            {getStringFromRecourse(R.string.orangeA),getStringFromRecourse(R.string.orangeB),getStringFromRecourse(R.string.orangeC)},
            {getStringFromRecourse(R.string.avocadoA),getStringFromRecourse(R.string.avocadoB),getStringFromRecourse(R.string.avocadoC)},
            {getStringFromRecourse(R.string.cherryA),getStringFromRecourse(R.string.cherryB),getStringFromRecourse(R.string.cherryC)},
            {getStringFromRecourse(R.string.pearA),getStringFromRecourse(R.string.pearB),getStringFromRecourse(R.string.pearC)},
            {getStringFromRecourse(R.string.bananaA),getStringFromRecourse(R.string.bananaB),getStringFromRecourse(R.string.bananaC)},
            {getStringFromRecourse(R.string.dogA),getStringFromRecourse(R.string.dogB),getStringFromRecourse(R.string.dogC)},
            {getStringFromRecourse(R.string.catA),getStringFromRecourse(R.string.catB),getStringFromRecourse(R.string.catC)},
            {getStringFromRecourse(R.string.fishA),getStringFromRecourse(R.string.fishB),getStringFromRecourse(R.string.fishC)},
            {getStringFromRecourse(R.string.cowA),getStringFromRecourse(R.string.cowB),getStringFromRecourse(R.string.cowC)},
            {getStringFromRecourse(R.string.pigA),getStringFromRecourse(R.string.pigB),getStringFromRecourse(R.string.pigC)},
            {getStringFromRecourse(R.string.bumblebeeA),getStringFromRecourse(R.string.bumblebeeB),getStringFromRecourse(R.string.bumblebeeC)},
            {getStringFromRecourse(R.string.chefA),getStringFromRecourse(R.string.chefB),getStringFromRecourse(R.string.chefC)},
            {getStringFromRecourse(R.string.nannyA),getStringFromRecourse(R.string.nannyB),getStringFromRecourse(R.string.nannyC)},
            {getStringFromRecourse(R.string.nurseA),getStringFromRecourse(R.string.nurseB),getStringFromRecourse(R.string.nurseC)},
            {getStringFromRecourse(R.string.policeA),getStringFromRecourse(R.string.policeB),getStringFromRecourse(R.string.policeC)},
            {getStringFromRecourse(R.string.serviceA),getStringFromRecourse(R.string.serviceB),getStringFromRecourse(R.string.serviceC)},
            {getStringFromRecourse(R.string.studentA),getStringFromRecourse(R.string.studentB),getStringFromRecourse(R.string.studentC)},
    };

    private final String[] mCorrectAnswers = {getStringFromRecourse(R.string.appleC),getStringFromRecourse(R.string.orangeC),getStringFromRecourse(R.string.avocadoA),getStringFromRecourse(R.string.cherryB),getStringFromRecourse(R.string.pearB),getStringFromRecourse(R.string.bananaA),getStringFromRecourse(R.string.dogA),getStringFromRecourse(R.string.catB),getStringFromRecourse(R.string.fishA),getStringFromRecourse(R.string.cowC),getStringFromRecourse(R.string.pigA),getStringFromRecourse(R.string.bumblebeeC),getStringFromRecourse(R.string.chefA),getStringFromRecourse(R.string.nannyA),getStringFromRecourse(R.string.nurseA),getStringFromRecourse(R.string.policeA),getStringFromRecourse(R.string.serviceA),getStringFromRecourse(R.string.studentA)};

    public int getNumOfQuestions(){
        return numOfQuestions;
    }

    public String getQuestion (int a){
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a){
        String choice0 = mChoices[a][0];
        return choice0;
    }

    public String getChoice2(int a){
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a){
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswers[a];
        return  answer;
    }



}
