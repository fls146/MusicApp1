package com.example.niuban.musicapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        navigationButtons();
    }

    private void navigationButtons() {
        Button button = (Button) findViewById(R.id.loginButton);
        TextView registerLink = (TextView) findViewById(R.id.CReg);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v){
                startActivity(new Intent(LoginScreen.this, HomeScreen.class));
            }
        });

        registerLink.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.utsa.edu"));
                startActivity(browserIntent);
            }

        });
    }

}
