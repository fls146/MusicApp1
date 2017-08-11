package com.example.niuban.musicapp;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;

public class AlarmSongService extends Service {

    MediaPlayer media_song;
    int startId;
    boolean isRunning;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        String state = intent.getExtras().getString("extra");

        assert state !=null;
        switch (state) {
            case "alarm on":
                startId = 1;
                break;
            case "alarm off":
                startId = 0;
                break;
            default:
                startId = 0;
                break;
        }

        if(!this.isRunning && startId == 1) {
            media_song = MediaPlayer.create(this, R.raw.test);
            media_song.start();
            this.isRunning = true;
            this.startId = 0;

            NotificationManager not_man = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            Intent main_intent = new Intent(this.getApplicationContext(), AlarmScreen.class);
            PendingIntent pendingIntentMain = PendingIntent.getActivity(this, 0, main_intent, 0);

            Notification not_popup = new Notification.Builder(this)
                    .setContentTitle("Alarm is going off!").setContentText("Snooze")
                    .setContentIntent(pendingIntentMain).setSmallIcon(R.drawable.small_alarm)
                    .setAutoCancel(true).build();
            not_man.notify(0,not_popup);
        } else if(this.isRunning && startId == 0) {
            media_song.stop();
            media_song.reset();
            this.isRunning = false;
            this.startId = 0;
        } else if(!this.isRunning && startId == 0) {
            this.isRunning = false;
            this.startId = 1;
        } else if(this.isRunning && startId == 1) {
            this.isRunning = true;
            this.startId = 1;
        }

        return START_NOT_STICKY;
    }

}
