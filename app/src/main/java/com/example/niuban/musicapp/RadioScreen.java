package com.example.niuban.musicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RadioScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_screen);
        radioNavButtons();
    }

    private void radioNavButtons() {
        Button button0 = (Button) findViewById(R.id.RadioBackButton);
        button0.setOnClickListener(new View.OnClickListener() {

            public void onClick (View v){
                finish();
            }
        });
    }
}
