package com.example.niuban.musicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewAlarmScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_alarm_screen);
        newAlarmNavButtons();
    }
    private void newAlarmNavButtons() {
        Button button1 = (Button) findViewById(R.id.NewAlarmCancelButton);
        Button button2 = (Button) findViewById(R.id.NewAlarmAcceptButton);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                finish();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                finish();
            }
        });
    }
}
