package com.example.aleksey.learnhebrew.generals.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.aleksey.learnhebrew.R;

public class PoemAlphabet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poem_alphabet);
    }

    public void backtomainpage(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
}
