package com.example.myapplication;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainScreenApp extends AppCompatActivity {

    Button showLevelsBtn,easyLevel,mediumLevel,hardLevel;
    MediaPlayer soundClick;
    SharedPreferences sp;

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(MainScreenApp.this, BackgroundSoundService.class);
        startService(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent myService = new Intent(MainScreenApp.this, BackgroundSoundService.class);
        setContentView(R.layout.activity_main_screen_app);
        startService(myService);
        sp = getSharedPreferences("details",MODE_PRIVATE);
        soundClick = MediaPlayer.create(getApplicationContext(), R.raw.menu_click);
        showLevelsBtn = findViewById(R.id.MoveToMemoryActivity);
        easyLevel = findViewById(R.id.easyLevel);
        mediumLevel = findViewById(R.id.mediumLevel);
        hardLevel = findViewById(R.id.hardLevel);





        ObjectAnimator animator = ObjectAnimator.ofFloat(showLevelsBtn, "scaleX", 1.3F).setDuration(2000);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(showLevelsBtn, "scaleY",1.3F).setDuration(2000);
        AnimatorSet set1 = new AnimatorSet();
        set1.playTogether(animator,animator2);
        set1.start();

        easyLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundClick.start();
                Intent switchActivityIntent = new Intent(MainScreenApp.this, matching_game.class);
                switchActivityIntent.putExtra("LEVEL", "easy");
                AlertDialog.Builder builder = new AlertDialog.Builder(MainScreenApp.this);
                                            View dialogView = getLayoutInflater().inflate(R.layout.activity_enter_your_name, null);
                                            EditText name = dialogView.findViewById(R.id.name);
                                            builder.setView(dialogView).setPositiveButton("Register", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    switchActivityIntent.putExtra("userName", name.getText());
                                                    Toast.makeText(MainScreenApp.this, name.getText(), Toast.LENGTH_SHORT).show();
                                                    startActivity(switchActivityIntent);
                                                    stopService(myService);                                                }
                                            }).show();
            }
        });

        mediumLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundClick.start();
                stopService(myService);
                Intent switchActivityIntent = new Intent(MainScreenApp.this, matching_game.class);
                switchActivityIntent.putExtra("LEVEL", "medium");
                startActivity(switchActivityIntent);
            }
        });

        hardLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundClick.start();
                stopService(myService);
                Intent switchActivityIntent = new Intent(MainScreenApp.this, matching_game.class);
                switchActivityIntent.putExtra("LEVEL", "hard");
                startActivity(switchActivityIntent);
            }
        });






        showLevelsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundClick.start();
                showLevelsBtn.setVisibility(View.GONE);
                easyLevel.setVisibility(View.VISIBLE);
                mediumLevel.setVisibility(View.VISIBLE);
                hardLevel.setVisibility(View.VISIBLE);
            }
        });
    }
}