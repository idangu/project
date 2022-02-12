package com.example.myapplication;

import android.content.Intent;
import android.media.Image;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class showCard extends AppCompatActivity {
    ImageView cardImg,speakrImage;
    TextView cardName;
    TextToSpeech mTTs;
    String nameOfCard;
    Button nextScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_card);
        nameOfCard =getIntent().getStringExtra("nameCard");
        nextScreen = findViewById(R.id.nextScreen);
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
        speakrImage = findViewById(R.id.speakrImage);
        speakrImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTTs.speak(nameOfCard, TextToSpeech.QUEUE_FLUSH, null);

            }
        });
        cardImg = findViewById(R.id.cardImage);
        cardName = findViewById(R.id.cardName);
        cardImg.setBackgroundResource(getIntent().getIntExtra("imageCard",0));
        cardName.setText(nameOfCard);

        nextScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_OK,intent );
                finish();
            }
        });



    }
}