package com.example.cityguideapp.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cityguideapp.R;
import com.example.cityguideapp.User.UserDashboard;

public class SplashScreen extends AppCompatActivity {

    ImageView backgroundImage;
    TextView poweredBy;
    Animation side_anim, bottom_anim;
    private static int SPLASH_TIMER = 3500;
    SharedPreferences onBoarding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        backgroundImage = (ImageView) findViewById(R.id.backgroundImage);
        poweredBy = (TextView) findViewById(R.id.poweredBy);

        side_anim = AnimationUtils.loadAnimation(this, R.anim.side_anim);
        bottom_anim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);

        backgroundImage.setAnimation(side_anim);
        poweredBy.setAnimation(bottom_anim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onBoarding = getSharedPreferences("onBoarding", MODE_PRIVATE);
                boolean isFirstTime = onBoarding.getBoolean("firstTime", true);

                if (isFirstTime) {
                    SharedPreferences.Editor editor = onBoarding.edit();
                    editor.putBoolean("firstTime", false);
                    editor.commit();

                    Intent intent = new Intent(SplashScreen.this, OnBoarding.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(SplashScreen.this, UserDashboard.class);
                    startActivity(intent);
                    finish();
                }

            }
        }, SPLASH_TIMER);
    }
}
