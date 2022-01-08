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

    Button moveToMemoryGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen_app);
        moveToMemoryGame = findViewById(R.id.MoveToMemoryActivity);
        ObjectAnimator animator = ObjectAnimator.ofFloat(moveToMemoryGame, "scaleX",2).setDuration(2000);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(moveToMemoryGame, "scaleY",2).setDuration(2000);
        AnimatorSet set1 = new AnimatorSet();
        set1.playTogether(animator,animator2);
        set1.start();



        moveToMemoryGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();
            }
        });
    }

    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, matching_game.class);
        startActivity(switchActivityIntent);
    }
}