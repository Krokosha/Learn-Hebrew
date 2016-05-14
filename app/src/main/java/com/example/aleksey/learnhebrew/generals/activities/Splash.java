package com.example.aleksey.learnhebrew.generals.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aleksey.learnhebrew.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread logoTimer = new Thread()
        {
            public void run()
            {
                try
                {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            TextView tvSplash = (TextView) findViewById(R.id.tvSplash);
                            ImageView ivLogo = (ImageView) findViewById(R.id.ivLogo);

                            Animation animation = AnimationUtils.loadAnimation(
                                    getApplicationContext(), R.anim.alpha);

                            tvSplash.startAnimation(animation);
                            ivLogo.startAnimation(animation);

                        }
                    });

                    int logoTimer = 0;
                    while(logoTimer < 2500)
                    {
                        sleep(100);
                        logoTimer = logoTimer +100;
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            ImageView imageView = (ImageView) findViewById(R.id.ivLogo);
                            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                                    R.anim.setleft);
                            imageView.startAnimation(animation);
                        }
                    });


                    logoTimer = 0;
                    while(logoTimer < 500)
                    {
                        sleep(100);
                        logoTimer = logoTimer +100;
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            ImageView imageView = (ImageView) findViewById(R.id.ivLogo);
                            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),
                                    R.anim.setright);
                            imageView.startAnimation(animation);
                        }
                    });

                    logoTimer = 0;
                    while(logoTimer < 1500)
                    {
                        sleep(100);
                        logoTimer = logoTimer +100;
                    }

                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    finish();
                }
            }
        };
        logoTimer.start();
    }
}
