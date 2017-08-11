package com.example.niuban.musicapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;


public class AlarmScreen extends AppCompatActivity {

    AlarmManager alarm_manager;
    TimePicker alarm_timepicker;
    TextView alarm_updateText;
    Context context;
    PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_screen);
        this.context = this;
        alarm_manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarm_timepicker = (TimePicker) findViewById(R.id.timePicker);
        alarm_updateText = (TextView) findViewById(R.id.updateText);
        final Calendar calendar = Calendar.getInstance();

        final Intent intent = new Intent (this.context, AlarmReciever.class);

        Button set_alarm = (Button) findViewById(R.id.SetButton);

        set_alarm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calendar.set(Calendar.HOUR_OF_DAY, alarm_timepicker.getHour());
                calendar.set(Calendar.MINUTE, alarm_timepicker.getMinute());

                int hour = alarm_timepicker.getHour();
                int minute = alarm_timepicker.getMinute();
                String hour_string;
                String minute_string;

                if(hour > 12)
                    hour_string = String.valueOf(hour - 12);
                else
                    hour_string = String.valueOf(hour);

                if(minute < 10)
                    minute_string = "0" + String.valueOf(minute);
                else
                    minute_string = String.valueOf(minute);

                set_alarm_text("Alarm set " + hour_string + ":" + minute_string);
                intent.putExtra("extra", "alarm on");
                pendingIntent = PendingIntent.getBroadcast(AlarmScreen.this, 0, intent,
                        PendingIntent.FLAG_UPDATE_CURRENT);

                alarm_manager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(), pendingIntent);
            }
        });

        Button off_alarm = (Button) findViewById(R.id.OffButton);
        off_alarm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                alarm_manager.cancel(pendingIntent);
                set_alarm_text("Alarm Off");
                intent.putExtra("extra", "alarm off");
                sendBroadcast(intent);
            }
        });
    }

    private void set_alarm_text(String output) {
        alarm_updateText.setText(output);
    }
}
