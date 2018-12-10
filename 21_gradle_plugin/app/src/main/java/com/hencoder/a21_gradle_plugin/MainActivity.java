package com.hencoder.a21_gradle_plugin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        long startTime = SystemClock.uptimeMillis();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("MainActivity.onCreate()Z 经过的时间: " + (SystemClock.uptimeMillis() - startTime));
    }
}
