package com.example.cityguideapp.Common;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.transition.Slide;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cityguideapp.HelperClasses.SliderAdapter;
import com.example.cityguideapp.R;
import com.example.cityguideapp.User.UserDashboard;

public class OnBoarding extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dots_layout;
    SliderAdapter sliderAdapter;
    Button lets_get_started_btn;
    Animation animation;
    int currentPosition;
    TextView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding);

        viewPager = (ViewPager) findViewById(R.id.slider);
        dots_layout = (LinearLayout) findViewById(R.id.dots_layout);
        lets_get_started_btn = (Button) findViewById(R.id.lets_get_started_btn);
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);
    }

    public void skipClick(View view) {
        Intent intent = new Intent(OnBoarding.this, UserDashboard.class);
        startActivity(intent);
        finish();
    }

    public void nextClick(View view) {
        viewPager.setCurrentItem(currentPosition + 1);
    }

    private void addDots(int position) {
        dots = new TextView[4];
        dots_layout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);

            dots_layout.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            currentPosition = position;
            addDots(position);
            if (position == 0) {
                lets_get_started_btn.setVisibility(View.INVISIBLE);
            } else if(position == 1) {
                lets_get_started_btn.setVisibility(View.INVISIBLE);
            } else if(position == 2) {
                lets_get_started_btn.setVisibility(View.INVISIBLE);
            } else {
                animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bottom_anim);
                lets_get_started_btn.setAnimation(animation);
                lets_get_started_btn.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
