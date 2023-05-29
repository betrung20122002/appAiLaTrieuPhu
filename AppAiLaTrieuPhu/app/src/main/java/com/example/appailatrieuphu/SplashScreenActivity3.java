package com.example.appailatrieuphu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreenActivity3 extends AppCompatActivity {

    private ImageView logo;
    private static int splashTimeOut=4000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen3);

        logo = findViewById(R.id.logo);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreenActivity3.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, splashTimeOut);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.xoay);
        logo.startAnimation(myanim);
    }
}