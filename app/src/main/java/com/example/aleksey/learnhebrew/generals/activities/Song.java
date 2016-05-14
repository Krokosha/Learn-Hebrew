package com.example.aleksey.learnhebrew.generals.activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.aleksey.learnhebrew.R;

public class Song extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
    }

    public void stop(View view) {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }

    }

    public void playSong(View view) {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.song);
            mediaPlayer.start();
        } else if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    public void pausa(View view) {
        if (mediaPlayer == null) {

        } else {
            mediaPlayer.pause();
        }
    }

    public void backToMain(View v) {
        if (mediaPlayer == null) {
            finish();
        } else {
            mediaPlayer.stop();
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.main:
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                return true;
            case R.id.alphabet1:
                startActivity(new Intent(getApplicationContext(), Alphabet.class));
                return true;

//            case R.id.myDictionary:
//                if (ParseUser.getCurrentUser() != null) {
//                    startActivity(new Intent(getApplicationContext(), ListOfMyWords.class));
//                } else {
//                    startActivity(new Intent(getApplicationContext(), LogIn.class));
//                }
//                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
