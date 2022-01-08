package com.example.myapplication;

import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainScreenApp extends AppCompatActivity {

    Button moveToMemoryGame,completeSentences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen_app);
        moveToMemoryGame = findViewById(R.id.MoveToMemoryActivity);
        completeSentences = findViewById(R.id.completeSentences);

        ObjectAnimator animator = ObjectAnimator.ofFloat(moveToMemoryGame, "scaleX", 1.3F).setDuration(2000);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(moveToMemoryGame, "scaleY",1.3F).setDuration(2000);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(completeSentences, "scaleX",1.3F).setDuration(2000);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(completeSentences, "scaleY",1.3F).setDuration(2000);
        AnimatorSet set1 = new AnimatorSet();
        set1.playTogether(animator,animator2,animator3,animator4);
        set1.start();


        completeSentences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent switchActivityIntent = new Intent(MainScreenApp.this, MainActivity.class);
                startActivity(switchActivityIntent);
            }
        });



        moveToMemoryGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent switchActivityIntent = new Intent(MainScreenApp.this, matching_game.class);
                startActivity(switchActivityIntent);
            }
        });
    }
}