package com.example.niuban.musicapp;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.ToggleButton;

import java.io.IOException;


public class RadioScreen extends AppCompatActivity {

    private MediaPlayer player;
    private ImageButton buttonPlay;
    private ImageButton buttonStop;
    private ToggleButton toggleMute;
    private AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_screen);

        audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        SeekBar volControl = (SeekBar)findViewById(R.id.VolumeBar);
        volControl.setMax(maxVolume);
        volControl.setProgress(curVolume);
        volControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStopTrackingTouch(SeekBar arg0) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar arg0) {
            }

            @Override
            public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, arg1, 0);
            }
        });

        initializeUIElements();
        initializeMediaPlayer();
        radioNavButtons();

        toggleMute.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    audioManager.setStreamMute(AudioManager.STREAM_MUSIC, true); // for mute
                } else {
                    // The toggle is disabled
                    audioManager.setStreamMute(AudioManager.STREAM_MUSIC, false);  //for unmute
                }
            }
        });
    }

    private void initializeUIElements() {
        buttonPlay = (ImageButton) findViewById(R.id.PlayButton);
        buttonStop = (ImageButton) findViewById(R.id.PauseButton);

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                startPlaying();
            }
        });

        buttonStop.setEnabled(false);
        buttonStop.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                stopPlaying();
            }
        });

        toggleMute = (ToggleButton) findViewById(R.id.MuteToggleButton);
    }

    private void initializeMediaPlayer() {
        String url = "http://138.197.66.171:8000/stream.mp3";
        player = new MediaPlayer();
        player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            player.setDataSource(url);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void startPlaying() {
        buttonStop.setEnabled(true);
        buttonPlay.setEnabled(false);

        player.prepareAsync();
        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            public void onPrepared(MediaPlayer mp) {
                player.start();
            }
        });
    }

    private void stopPlaying() {
        if (player.isPlaying()) {
            player.stop();
            player.release();
            initializeMediaPlayer();
        }

        buttonPlay.setEnabled(true);
        buttonStop.setEnabled(false);
    }

    private void radioNavButtons() {
        ImageButton aButton = (ImageButton) findViewById(R.id.AlarmButton);
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
