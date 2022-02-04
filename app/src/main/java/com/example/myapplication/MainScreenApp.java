package com.example.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainScreenApp extends AppCompatActivity {

    Button showLevelsBtn,easyLevel,mediumLevel,hardLevel;
    MediaPlayer soundClick;
    SharedPreferences sp;
    Intent intent;
    Intent myService;
    boolean isMute=false;

    @Override
    protected void onPause() {
        super.onPause();
        stopService(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        intent = new Intent(MainScreenApp.this, BackgroundSoundService.class);
        startService(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(intent);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
       if(item.getItemId() == R.id.action_mute){
           if(!isMute) {
              stopService(intent);
              isMute = true;
              item.setIcon(R.drawable.unmute);
           }else{
               startService(intent);
               item.setIcon(R.drawable.mute);
               isMute = false;
           }
           return true;
       }else if(item.getItemId() == R.id.action_home){
           String alreadyHomePage = getResources().getString(R.string.homePage);
           Toast.makeText(MainScreenApp.this, alreadyHomePage, Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myService = new Intent(MainScreenApp.this, BackgroundSoundService.class);
        setContentView(R.layout.activity_main_screen_app);
        startService(myService);
        sp = getSharedPreferences("details",MODE_PRIVATE);
        soundClick = MediaPlayer.create(getApplicationContext(), R.raw.menu_click);
        showLevelsBtn = findViewById(R.id.MoveToMemoryActivity);
        easyLevel = findViewById(R.id.easyLevel);
        mediumLevel = findViewById(R.id.mediumLevel);
        hardLevel = findViewById(R.id.hardLevel);
        ImageView logo = findViewById(R.id.logo);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ObjectAnimator oa1 = ObjectAnimator.ofFloat(logo, "scaleX", 1f, 0.5f);
                final ObjectAnimator oa2 = ObjectAnimator.ofFloat(logo, "scaleX", 0.5f, 1f);
                oa1.setInterpolator(new DecelerateInterpolator());
                oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                oa1.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        oa2.start();
                    }
                });
                oa1.start();
            }
        });
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
                openNameDialog(switchActivityIntent);
            }
        });

        mediumLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundClick.start();
                Intent switchActivityIntent = new Intent(MainScreenApp.this, matching_game.class);
                switchActivityIntent.putExtra("LEVEL", "medium");
                openNameDialog(switchActivityIntent);
            }
        });

        hardLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundClick.start();
                Intent switchActivityIntent = new Intent(MainScreenApp.this, matching_game.class);
                switchActivityIntent.putExtra("LEVEL", "hard");
                openNameDialog(switchActivityIntent);
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

    public void openNameDialog(Intent switchActivityIntent){
        String register = getResources().getString(R.string.registerName);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainScreenApp.this);
        View dialogView = getLayoutInflater().inflate(R.layout.activity_enter_your_name, null);
        EditText name = dialogView.findViewById(R.id.name);
        builder.setView(dialogView).setPositiveButton(register, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switchActivityIntent.putExtra("userName", name.getText().toString());
                Toast.makeText(MainScreenApp.this, name.getText(), Toast.LENGTH_SHORT).show();
                startActivity(switchActivityIntent);
                stopService(myService);                                                }
        }).show();
    }
}