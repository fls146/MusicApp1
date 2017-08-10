package com.example.niuban.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class RadioScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_screen);
        radioNavButtons();
    }

    private void radioNavButtons() {
        ImageButton aButton= (ImageButton) findViewById(R.id.AlarmButton);
        ImageButton nButton = (ImageButton) findViewById(R.id.NewsButton);

        aButton.setOnClickListener(new View.OnClickListener() {

            public void onClick (View v){
                startActivity(new Intent(RadioScreen.this, AlarmScreen.class));
            }
        });

        nButton.setOnClickListener(new View.OnClickListener() {

            public void onClick (View v){
                startActivity(new Intent(RadioScreen.this, NewsScreen.class));
            }
        });

    }
}
