package com.example.niuban.musicapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AlarmScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_screen);
        alarmNavButtons();
    }

    private void alarmNavButtons() {
        Button button = (Button) findViewById(R.id.AlarmBackButton);
        FloatingActionButton mfab = (FloatingActionButton) findViewById(R.id.newAlarmButton);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                finish();
            }
        });

        mfab.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                startActivity(new Intent(AlarmScreen.this, NewAlarmScreen.class));
            }
        });
    }
}
