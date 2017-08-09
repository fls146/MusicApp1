package com.example.niuban.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        homeNavButtons();
    }

    private void homeNavButtons() {
        Button button1 = (Button) findViewById(R.id.RadioButton);
        Button button2 = (Button) findViewById(R.id.AlarmButton);
        Button button3 = (Button) findViewById(R.id.NewsButton);

        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick (View v){
                startActivity(new Intent(HomeScreen.this, RadioScreen.class));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {

            public void onClick (View v){
                startActivity(new Intent(HomeScreen.this, AlarmScreen.class));
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {

            public void onClick (View v){
                startActivity(new Intent(HomeScreen.this, NewsScreen.class));
            }
        });
    }
}
