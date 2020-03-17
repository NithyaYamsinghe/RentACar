package com.example.carapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.carapp.HelperClasses.SliderAdapter;

public class OnBoardingActivity extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout slideDots;
    SliderAdapter sliderAdapter;
    TextView []dots;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_onboarding);




        // Hooks
        viewPager = findViewById(R.id.slider);
        slideDots = findViewById(R.id.dots);


        // call the slider adapter
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        addDots(0); // Set default position
        viewPager.addOnPageChangeListener(changeListener);


    }

    private  void  addDots(int position){

        dots = new TextView[4];
        slideDots.removeAllViews(); // To clear views every time
        for (int i=0; i < dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);

            slideDots.addView(dots[i]);

        }

        if (dots.length > 0){
            dots[position].setTextColor(getResources().getColor(R.color.yellow));
        }

    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
         addDots(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}