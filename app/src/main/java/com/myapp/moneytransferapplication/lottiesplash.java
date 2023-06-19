package com.myapp.moneytransferapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;


public class lottiesplash extends AppCompatActivity {
    LottieAnimationView laview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent inext;
        inext=new Intent(lottiesplash.this,MainActivity.class);


        new Handler().postDelayed(() -> {
            startActivity(inext);
            laview.setAnimation(R.raw.lottie);
            laview.playAnimation();
            laview.setRepeatCount(ValueAnimator.INFINITE);
            finish();

        },5000);
        getSupportActionBar();
        setContentView(R.layout.activity_lottiesplash);



    }
}