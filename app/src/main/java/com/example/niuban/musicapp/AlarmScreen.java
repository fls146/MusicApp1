package com.example.niuban.musicapp;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class AlarmScreen extends AppCompatActivity {

    static final int Dialog_ID = 0;
    int hour;
    int min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_screen);
        alarmNavButtons();
    }

    private void alarmNavButtons() {
        FloatingActionButton mfab = (FloatingActionButton) findViewById(R.id.newAlarmButton);

        mfab.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                showDialog(Dialog_ID);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if(id == Dialog_ID)
            return new TimePickerDialog(AlarmScreen.this, tpAlarm, hour, min, false);
        return null;
    }

    protected TimePickerDialog.OnTimeSetListener tpAlarm = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute ) {
            hour = hourOfDay;
            min = minute;
            Toast.makeText(AlarmScreen.this, hour + ":" + min, Toast.LENGTH_LONG).show();
        }
    };

}
