package com.example.niuban.musicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewsScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_screen);
        newsNavButtons();
    }

    private void newsNavButtons() {
        Button button = (Button) findViewById(R.id.NewsBackButton);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                finish();
            }
        });
    }
}
