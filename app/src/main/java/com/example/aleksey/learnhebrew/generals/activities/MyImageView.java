package com.example.aleksey.learnhebrew.generals.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.aleksey.learnhebrew.R;
import com.example.aleksey.learnhebrew.adapters.AlphabetAdapter;

public class MyImageView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        AlphabetAdapter myAdapterForAlphabet = new AlphabetAdapter(getApplicationContext());
        pager.setAdapter(myAdapterForAlphabet);
        pager.setCurrentItem(getIntent().getIntExtra("obId", 0));
    }
}
