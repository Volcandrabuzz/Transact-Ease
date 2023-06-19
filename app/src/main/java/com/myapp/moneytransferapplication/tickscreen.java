package com.myapp.moneytransferapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;

public class tickscreen extends AppCompatActivity {


    LottieAnimationView la;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        new Handler().postDelayed(() -> {
            la.setAnimation(R.raw.lottie);
            la.playAnimation();
            la.setRepeatCount(ValueAnimator.INFINITE);
            finish();

        },6000);
        getSupportActionBar();
        setContentView(R.layout.activity_tickscreen);




    }

}