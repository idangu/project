package com.example.myapplication;

public class QuestionLibrary {
    private String mQuestions[] = {
            "what is apple?",
            "what is orange?",
            "what is avokado?",
            "what is cherry?",
            "what is pear?",
            "what is banana?",
    };

    private int numOfQuestions = mQuestions.length;

    private String mChoices[][] = {
            {"תפוח","גזר","תפוז"},
            {"אפרסק","ענבים","תפוז"},
            {"קלמנטינה","אגס","אבוקדו"},
            {"מלון","דובדבן","אננס"},
            {"אגס","תפוז","תות"},
            {"ענבים","אפרסק","בננה"},
    };

    private final String[] mCorrectAnswers = {"תפוח","תפוז","אבוקדו","דובדבן","אגס","בננה"};

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
