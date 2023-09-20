package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MaterialButton buttonPrev, buttonNext;
    TextView titleTv;
    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewpager);
        buttonNext = findViewById(R.id.button_next);
        buttonNext.setOnClickListener(this);
        buttonPrev = findViewById(R.id.button_prev);
        buttonPrev.setOnClickListener(this);
        titleTv = findViewById(R.id.title_tv);

        ViewPager2Adapter viewPager2Adapter = new ViewPager2Adapter(this);
        viewPager2.setAdapter(viewPager2Adapter);
    }

    @Override
    public void onClick(View view) {
        MaterialButton button =(MaterialButton) view;
        String buttonText = button.getText().toString();
        int currentFragment = viewPager2.getCurrentItem();
        if(buttonText.equals("Next")){
            viewPager2.setCurrentItem(currentFragment + 1);
        } else {
            viewPager2.setCurrentItem(currentFragment - 1);
        }

    }
}