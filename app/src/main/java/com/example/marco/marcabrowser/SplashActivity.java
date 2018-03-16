package com.example.marco.marcabrowser;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;


public class SplashActivity extends AppCompatActivity {

    long Delay = 1250;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Timer RunSplash = new Timer();

        TimerTask ShowSplash = new TimerTask() {
            @Override
            public void run() {
                finish();

                Intent myIntent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(myIntent);
            }
        };

        RunSplash.schedule(ShowSplash, Delay);
    }
}