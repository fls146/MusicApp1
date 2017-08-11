package com.example.niuban.musicapp;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String fetchstring = intent.getExtras().getString("extra");

        Intent service_intent = new Intent(context, AlarmSongService.class);

        service_intent.putExtra("extra", fetchstring);

        context.startService(service_intent);
    }
}
