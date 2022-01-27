package com.example.myapplication;

public class QuestionLibrary {
    private String mQuestions[] = {
            "What country is the largest producer of apples?",
            "Which vitamin makes the orange juice excellent?",
            "Where does the word avocado come from?",
            "Sweet cherries which are raw have about 82%?",
            "What is a pear?",
            "Bananas are mostly picked when they are:",
            "Which animal family do dogs belong to?",
            "Can a cat see in total darkness?",
            "Sharks are commonly found in seas at what depth?",
            "How much water does a cow drink daily?",
            "What are baby pigs known as?",
            "In which season do bumblebees mate?",
            "Which Italian city is famous for its pizza and spaghetti?",
            "what is prob?",
            "How do puzzles help you?",
            "what is prod?",
            "When was the transistor invented?",
            "what is prof?",
    };

    private int numOfQuestions = mQuestions.length;

    private String mChoices[][] = {
            {"The USA","China","New Zealand"},
            {"Vitamin A","Vitamin C","Vitamin B"},
            {"Farsi","Greek","Spanish"},
            {"Water","Sugar","Protein"},
            {"A veggie","A fruit","A flower"},
            {"Green","Brown","Yellow"},
            {"Wolves","Lions","Coyotes"},
            {"Yes","No","Maybe"},
            {"2000 metres","4000 metres","3000 metres"},
            {"8 gallons","3 gallons","About a bathtub full"},
            {"Piglets","Wild boar","Babirusa"},
            {"Winter","Spring","Autumn"},
            {"Naples","Venice","Rome"},
            {"אריה","חתול","נמר"},
            {"They help you learn numbers","They help exercise the brain","They are a time pass"},
            {"אריה","חתול","נמר"},
            {"1946","1974","1947"},
            {"אריה","חתול","נמר"},
    };

    private final String[] mCorrectAnswers = {"China","Vitamin C","Spanish","Water","A fruit","Green","Wolves","No","2000 metres","About a bathtub full","Piglets","Autumn","Naples","נמר","They help exercise the brain","נמר","1947","נמר"};

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
