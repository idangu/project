package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class winner extends AppCompatActivity {

    TextView points;
    Button homeBtn;
    SharedPreferences mUserInfo;
    Button scoreBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);
        mUserInfo = getSharedPreferences("users", MODE_PRIVATE);
        int mScore = getIntent().getIntExtra("score",0);
        String userName = getIntent().getStringExtra("userName");
        homeBtn = findViewById(R.id.homeButton);
        scoreBtn = findViewById(R.id.scoreButton);
        points = findViewById(R.id.points);
        points.setText(userName + " " + points.getText().toString() + " " + Integer.toString(mScore));
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(winner.this, MainScreenApp.class);
                startActivity(intent);
            }
        });
        scoreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int size = mUserInfo.getInt("size", 0);
                size++;
                SharedPreferences.Editor editor = mUserInfo.edit();
                editor.putInt("size", size);
                editor.putString("userName_" + size, userName);
                editor.putInt("userScore_" + size,  mScore);
                editor.apply();
                Intent intent = new Intent(winner.this, score.class);
                startActivity(intent);
            }
        });
    }
}