package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Dictionary;
import java.util.Hashtable;

public class MainActivity extends AppCompatActivity {

    private QuestionLibrary mQuestionLibarary = new QuestionLibrary();

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private String mAnswer;
    private int mScore;
    private int mQuestionNumber = 0;
    private int counter=0;
    String userName;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Dictionary items = new Hashtable();
        items.put("res/drawable/apple.png", 0);
        items.put("res/drawable/orange.png", 1);
        items.put("res/drawable/avokado.png", 2);
        items.put("res/drawable/cherry.png", 3);
        items.put("res/drawable/pear.png", 4);
        items.put("res/drawable/banana.png", 5);
        items.put("res/drawable/dog.png", 6);
        items.put("res/drawable/cat.png", 7);
        items.put("res/drawable/fish.png", 8);
        items.put("res/drawable/cow.png", 9);
        items.put("res/drawable/pig.png", 10);
        items.put("res/drawable/bumblebee.png", 11);
        items.put("res/drawable/cook.png", 12);
        items.put("res/drawable/nanny.png", 13);
        items.put("res/drawable/nurse.png", 14);
        items.put("res/drawable/police.png", 15);
        items.put("res/drawable/service.png", 16);
        items.put("res/drawable/student.png", 17);
        String NameOfImage = getIntent().getStringExtra("NAME_OF_IMAGE");
        mScore = getIntent().getIntExtra("score",0);
        mQuestionNumber = (int) items.get(NameOfImage);
        mScoreView = findViewById(R.id.score);
        mQuestionView = findViewById(R.id.question);
        mButtonChoice1 = findViewById(R.id.choice1);
        mButtonChoice2 = findViewById(R.id.choice2);
        mButtonChoice3 = findViewById(R.id.choice3);
        mScoreView.setText(Integer.toString(mScore));
        userName = getIntent().getStringExtra("userName");





        updateQuestion();

        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mButtonChoice1.getText() == mAnswer){
                    mScore = mScore + 5;
                    updateScore(mScore);
                    Toast.makeText(MainActivity.this,getResources().getString(R.string.correctTxt) , Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.wrongTxt), Toast.LENGTH_SHORT).show();
                }
                counter++;
                Intent resultIntent = new Intent();
                resultIntent.putExtra("scoreGame", mScore);
                setResult(Activity.RESULT_OK, resultIntent);
                isWinner();
                finish();
            }
        });



        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mButtonChoice2.getText() == mAnswer){
                    mScore = mScore + 5;
                    updateScore(mScore);
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.correctTxt), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.wrongTxt), Toast.LENGTH_SHORT).show();
                }
                counter++;
                Intent resultIntent = new Intent();
                resultIntent.putExtra("scoreGame", mScore);
                setResult(Activity.RESULT_OK, resultIntent);
                isWinner();
                finish();
            }
        });

        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mButtonChoice3.getText() == mAnswer){
                    mScore = mScore + 5;
                    updateScore(mScore);
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.correctTxt), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.wrongTxt), Toast.LENGTH_SHORT).show();
                }
                counter++;
                Intent resultIntent = new Intent();
                resultIntent.putExtra("scoreGame", mScore);
                setResult(Activity.RESULT_OK, resultIntent);
                isWinner();
                finish();
            }
        });

    }

    private void updateQuestion(){
        if(mQuestionNumber < mQuestionLibarary.getNumOfQuestions()) {
            mQuestionView.setText(mQuestionLibarary.getQuestion((mQuestionNumber)));
            mButtonChoice1.setText(mQuestionLibarary.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(mQuestionLibarary.getChoice2(mQuestionNumber));
            mButtonChoice3.setText(mQuestionLibarary.getChoice3(mQuestionNumber));


            mAnswer = mQuestionLibarary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        }
    }

    public void isWinner(){
        boolean winner = getIntent().getBooleanExtra("win", true);
        if(winner){
            Intent intent = new Intent(MainActivity.this,winner.class);
            intent.putExtra("userName", userName.toString());
            intent.putExtra("score", mScore);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
    };

    private void updateScore(int point){
        mScoreView.setText("" + mScore);
    }
}

