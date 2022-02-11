package com.example.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.speech.tts.TextToSpeech;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;


public class matching_game extends AppCompatActivity {
    Button button1;
    private int objectLength = 12;
    int mScore = 0;
    TextToSpeech mTTs;
    MediaPlayer sound;
    TextView userName;
    MenuItem soundItem;
    TextView score;
    int counter = 0;
    int delayMills = 0;
    boolean isMute;


    //put the score update from Questions layot
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case (3) : {
                if (resultCode == Activity.RESULT_OK) {
                    mScore = data.getIntExtra("scoreGame",0);
                    score.setText(Integer.toString(mScore));
                }
                break;
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.action_mute){
            manageMusic(item);
        }else if(item.getItemId() == R.id.action_home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu,menu);
        soundItem = menu.findItem(R.id.action_mute);
        manageMusic(soundItem);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching_game);
        userName = findViewById(R.id.userName);
        userName.setText(getIntent().getStringExtra("userName"));
        score = findViewById(R.id.scoreGame);
        score.setText(Integer.toString(mScore));
        sound = MediaPlayer.create(getApplicationContext(), R.raw.duck);
        sound.start();
        sound.setLooping(true);

        // create TextToSpeech for answers

        mTTs = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    int result = mTTs.setLanguage(Locale.US);

                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                        Log.e("TTS","Language not supported");
                    }
                }
            }
        });
        List<Integer> list = new ArrayList<Integer>();
        Button[] buttons = new Button[objectLength];
        buttons[0] = (Button)findViewById(R.id.btn1);
        buttons[1] = (Button)findViewById(R.id.btn2);
        buttons[2] = (Button)findViewById(R.id.btn3);
        buttons[3] = (Button)findViewById(R.id.btn4);
        buttons[4] = (Button)findViewById(R.id.btn5);
        buttons[5] = (Button)findViewById(R.id.btn6);
        buttons[6] = (Button)findViewById(R.id.btn7);
        buttons[7] = (Button)findViewById(R.id.btn8);
        buttons[8] = (Button)findViewById(R.id.btn9);
        buttons[9] = (Button)findViewById(R.id.btn10);
        buttons[10] = (Button)findViewById(R.id.btn11);
        buttons[11] = (Button)findViewById(R.id.btn12);
        String level;

        level = getIntent().getStringExtra("LEVEL");
        isMute = getIntent().getBooleanExtra("isMute",false);




        // check level and put list of Images and delayMills

        if (level.equals("easy")){
            delayMills = 1000;
            list.add(R.drawable.apple);
            list.add(R.drawable.orange);
            list.add(R.drawable.avokado);
            list.add(R.drawable.banana);
            list.add(R.drawable.cherry);
            list.add(R.drawable.apple);
            list.add(R.drawable.orange);
            list.add(R.drawable.avokado);
            list.add(R.drawable.banana);
            list.add(R.drawable.cherry);
            list.add(R.drawable.pear);
            list.add(R.drawable.pear);
        }else if(level.equals("medium")){
            delayMills = 750;
            list.add(R.drawable.dog);
            list.add(R.drawable.pig);
            list.add(R.drawable.cow);
            list.add(R.drawable.bumblebee);
            list.add(R.drawable.cat);
            list.add(R.drawable.fish);
            list.add(R.drawable.dog);
            list.add(R.drawable.pig);
            list.add(R.drawable.cow);
            list.add(R.drawable.bumblebee);
            list.add(R.drawable.cat);
            list.add(R.drawable.fish);
        }else{
            delayMills = 500;
            list.add(R.drawable.police);
            list.add(R.drawable.nurse);
            list.add(R.drawable.service);
            list.add(R.drawable.cook);
            list.add(R.drawable.student);
            list.add(R.drawable.nanny);
            list.add(R.drawable.police);
            list.add(R.drawable.nurse);
            list.add(R.drawable.service);
            list.add(R.drawable.cook);
            list.add(R.drawable.student);
            list.add(R.drawable.nanny);
        }



        Collections.shuffle(list);
        button1 = findViewById(R.id.btn1);
        final int[] clicked = {0};
        final boolean[] turnOver = {false};
        final int[] lastClicked = {-1};


        for (int i=0;i<12;i++){
            buttons[i].setText("cardBack");
            buttons[i].setTextSize(0.0F);
            int finalI = i;
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(buttons[finalI].getText() == "cardBack" && !turnOver[0]){
                        final ObjectAnimator oa1 = ObjectAnimator.ofFloat(buttons[finalI], "scaleX", 1f, 0f);
                        final ObjectAnimator oa2 = ObjectAnimator.ofFloat(buttons[finalI], "scaleX", 0f, 1f);
                        oa1.setInterpolator(new DecelerateInterpolator());
                        oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                        oa1.addListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                buttons[finalI].setBackgroundResource(list.get(finalI));
                                oa2.start();
                            }
                        });
                        oa1.start();
                        buttons[finalI].setText(list.get(finalI));
                        buttons[finalI].setClickable(false);
                        if(clicked[0] == 0){
                            lastClicked[0] = finalI;
                        }
                        clicked[0]++;
                    } else if (buttons[finalI].getText() != "cardBack"){
                        buttons[finalI].setBackgroundResource(R.drawable.card);
                        buttons[finalI].setText("cardBack");
                        clicked[0]--;
                    }
                    if (clicked[0] == 2){
                        turnOver[0] = true;
                        if(buttons[finalI].getText() == buttons[lastClicked[0]].getText()) {
                            counter+=2;
                            mScore+=10;
                            score.setText(Integer.toString(mScore));
                            String toSpeak = (String) buttons[finalI].getText();
                            toSpeak = toSpeak.substring(13,toSpeak.length()-4);
                            mTTs.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
                            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                            new android.os.Handler(Looper.getMainLooper()).postDelayed(
                                    new Runnable() {
                                        public void run() {
                                            Intent switchActivityIntent = new Intent(matching_game.this,MainActivity.class);
                                            switchActivityIntent.putExtra("NAME_OF_IMAGE", buttons[finalI].getText());
                                            switchActivityIntent.putExtra("score", mScore);
                                            switchActivityIntent.putExtra("userName", userName.getText().toString());
                                            switchActivityIntent.putExtra("win", false);
                                            if(counter == objectLength){
                                                switchActivityIntent.putExtra("win", true);

                                            }
                                            startActivityForResult(switchActivityIntent,3);
                                            buttons[finalI].setVisibility(View.INVISIBLE);
                                            buttons[lastClicked[0]].setVisibility(View.INVISIBLE);
                                            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                                        }
                                    },
                                    delayMills);

                            buttons[finalI].setClickable(false);
                            buttons[lastClicked[0]].setClickable(false);
                            turnOver[0] = false;
                            clicked[0] = 0;
                        }
                        else{
                            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                            Handler handler = new Handler(Looper.getMainLooper());
                            Runnable runnable = new Runnable() {
                                @Override
                                public void run() {
                                    final ObjectAnimator oa1 = ObjectAnimator.ofFloat(buttons[finalI], "scaleX", 1f, 0f);
                                    final ObjectAnimator oa2 = ObjectAnimator.ofFloat(buttons[finalI], "scaleX", 0f, 1f);
                                    final ObjectAnimator oa3 = ObjectAnimator.ofFloat(buttons[lastClicked[0]], "scaleX", 1f, 0f);
                                    final ObjectAnimator oa4 = ObjectAnimator.ofFloat(buttons[lastClicked[0]], "scaleX", 0f, 1f);
                                    oa1.setInterpolator(new DecelerateInterpolator());
                                    oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                                    oa3.setInterpolator(new DecelerateInterpolator());
                                    oa4.setInterpolator(new AccelerateDecelerateInterpolator());
                                    oa3.addListener(new AnimatorListenerAdapter() {
                                        @Override
                                        public void onAnimationEnd(Animator animation) {
                                            super.onAnimationEnd(animation);
                                            buttons[finalI].setBackgroundResource(R.drawable.card);
                                            oa4.start();
                                        }
                                    });
                                    oa1.addListener(new AnimatorListenerAdapter() {
                                        @Override
                                        public void onAnimationEnd(Animator animation) {
                                            super.onAnimationEnd(animation);
                                            buttons[finalI].setBackgroundResource(R.drawable.card);
                                            oa2.start();
                                        }
                                    });
                                    oa1.start();
                                    oa3.start();
                                    buttons[finalI].setText("cardBack");
                                    clicked[0]--;
                                    clicked[0]--;
                                    buttons[lastClicked[0]].setBackgroundResource(R.drawable.card);
                                    buttons[lastClicked[0]].setText("cardBack");
                                    turnOver[0] = false;
                                    buttons[finalI].setClickable(true);
                                    buttons[lastClicked[0]].setClickable(true);
                                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                                    if(mScore>0){
                                        mScore--;
                                        score.setText(Integer.toString(mScore));
                                    }
                                }
                            };
                            handler.postDelayed(runnable, delayMills);
                        }
                    } else if (clicked[0] == 0){
                        turnOver[0] = false;
                    }
                }
            });
        }

    }
    private boolean manageMusic(MenuItem item){
        if(!isMute) {
            item.setIcon(R.drawable.unmute);
            sound.pause();
            isMute = true;
        }else{
            sound.start();
            item.setIcon(R.drawable.mute);
            isMute = false;
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTTs.stop();
        mTTs.shutdown();
        sound.stop();
        sound.release();
    }
}