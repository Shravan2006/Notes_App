package com.example.notesapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DURATION = 10000;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        progressBar = findViewById(R.id.progressBar);

        // Simulate loading process with a handler and postDelayed
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_DURATION);

        // Update progress bar continuously (optional)
        updateProgressBar();
    }

    private void updateProgressBar() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int progress = 0;
                while (progress <= 100) {
                    try {
                        Thread.sleep(50); // Simulate some loading delay
                        progressBar.setProgress(progress);
                        progress++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

