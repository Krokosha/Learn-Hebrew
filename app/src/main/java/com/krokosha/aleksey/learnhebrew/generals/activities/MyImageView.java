package com.krokosha.aleksey.learnhebrew.generals.activities;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.krokosha.aleksey.learnhebrew.R;
import com.krokosha.aleksey.learnhebrew.adapters.AlphabetAdapter;

public class MyImageView extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        AlphabetAdapter myAdapterForAlphabet = new AlphabetAdapter(getApplicationContext());
        pager.setAdapter(myAdapterForAlphabet);
        pager.setCurrentItem(getIntent().getIntExtra("obId", 0));
        initToolBar();

    }

    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_24dp);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(), Alphabet.class));
                    }
                }
        );
    }
}
