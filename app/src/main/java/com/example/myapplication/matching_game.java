package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class matching_game extends AppCompatActivity {
    Button button1;
    private int objectLength = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching_game);

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
                        buttons[finalI].setBackgroundResource(list.get(finalI));
                        buttons[finalI].setText(list.get(finalI));
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
                            Toast.makeText(matching_game.this, "Good Job!!", Toast.LENGTH_SHORT).show();
                            buttons[finalI].setClickable(false);
                            buttons[lastClicked[0]].setClickable(false);
                            turnOver[0] = false;
                            clicked[0] = 0;
                        }
                    } else if (clicked[0] == 0){
                        turnOver[0] = false;
                    }
                }

            });


        }
    }
}