package com.example.myapplication;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreenApp extends AppCompatActivity {

    Button showLevelsBtn,easyLevel,mediumLevel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen_app);
        showLevelsBtn = findViewById(R.id.MoveToMemoryActivity);
        easyLevel = findViewById(R.id.easyLevel);
        mediumLevel = findViewById(R.id.mediumLevel);



        ObjectAnimator animator = ObjectAnimator.ofFloat(showLevelsBtn, "scaleX", 1.3F).setDuration(2000);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(showLevelsBtn, "scaleY",1.3F).setDuration(2000);
        AnimatorSet set1 = new AnimatorSet();
        set1.playTogether(animator,animator2);
        set1.start();

        easyLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent switchActivityIntent = new Intent(MainScreenApp.this, matching_game.class);
                switchActivityIntent.putExtra("LEVEL", "easy");
                startActivity(switchActivityIntent);
            }
        });

        mediumLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent switchActivityIntent = new Intent(MainScreenApp.this, matching_game.class);
                switchActivityIntent.putExtra("LEVEL", "medium");
                startActivity(switchActivityIntent);
            }
        });




        showLevelsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLevelsBtn.setVisibility(View.GONE);
                easyLevel.setVisibility(View.VISIBLE);
                mediumLevel.setVisibility(View.VISIBLE);
            }
        });
    }
}