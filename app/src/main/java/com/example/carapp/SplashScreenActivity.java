package com.example.carapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {

    private static  int SPLASH_TIMER = 5000;

    // Initializing variables
    ImageView backgroundImage;
    TextView sloganText;

    // Animation variables
    Animation sideAnim, sideBottomAnim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);


        // Hooks
        backgroundImage = findViewById(R.id.splash_background_image);
        sloganText = findViewById(R.id.slogan);

        // Animation
        sideAnim = AnimationUtils.loadAnimation(this, R.anim.side_animation);
        sideBottomAnim = AnimationUtils.loadAnimation(this, R.anim.side_bottom_animation);

        // Set animations on elements

       backgroundImage.setAnimation(sideAnim);
       sloganText.setAnimation(sideBottomAnim);

       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               Intent intent = new Intent(SplashScreenActivity.this, DashboardActivity.class);
               startActivity(intent);
               finish();
           }
       }, SPLASH_TIMER);

    }
}
