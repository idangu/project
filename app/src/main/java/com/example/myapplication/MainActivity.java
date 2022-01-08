package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
    private int mScore = 0;
    private int mQuestionNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent switchActivityIntent = new Intent(MainActivity.this,matching_game.class);
        Dictionary items = new Hashtable();
        items.put("res/drawable/apple.png", 0);
        items.put("res/drawable/orange.png", 1);
        items.put("res/drawable/avokado.png", 2);
        items.put("res/drawable/cherry.png", 3);
        items.put("res/drawable/pear.png", 4);
        items.put("res/drawable/banana.png", 5);
        String NameOfImage = getIntent().getStringExtra("NAME_OF_IMAGE");
        mScore = getIntent().getIntExtra("SCORE",0);
        mQuestionNumber = (int) items.get(NameOfImage);
        Toast.makeText(MainActivity.this, NameOfImage, Toast.LENGTH_LONG).show();
        mScoreView = findViewById(R.id.score);
        mQuestionView = findViewById(R.id.question);
        mButtonChoice1 = findViewById(R.id.choice1);
        mButtonChoice2 = findViewById(R.id.choice2);
        mButtonChoice3 = findViewById(R.id.choice3);


        updateQuestion();

        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mButtonChoice1.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                }
                switchActivityIntent.putExtra("SCORE", mScore);
                finish();
            }
        });

        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mButtonChoice2.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                }
                switchActivityIntent.putExtra("SCORE", mScore);
                finish();
            }
        });

        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mButtonChoice3.getText() == mAnswer){
                    mScore = mScore + 1;
                    updateScore(mScore);
                    Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                }
                switchActivityIntent.putExtra("SCORE", mScore);
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
        else{
            Intent switchActivityIntent = new Intent(MainActivity.this, MainScreenApp.class);
            startActivity(switchActivityIntent);
        }
    }

    private void updateScore(int point){
        mScoreView.setText("" + mScore);
    }
}

