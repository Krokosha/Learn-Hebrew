package com.krokosha.aleksey.learnhebrew.generals.activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.krokosha.aleksey.learnhebrew.R;

public class Song extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        initToolBar();
    }

    public void stop(View view) {
        stop();
    }

    @Override
    protected void onPause() {
        super.onPause();

        stop();
    }

    private void stop() {
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

    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_24dp);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    }
                }
        );
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        switch (id) {
//            case R.id.main:
//                startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                return true;
//            case R.id.alphabet1:
//                startActivity(new Intent(getApplicationContext(), Alphabet.class));
//                return true;

//            case R.id.myDictionary:
//                if (ParseUser.getCurrentUser() != null) {
//                    startActivity(new Intent(getApplicationContext(), ListOfMyWords.class));
//                } else {
//                    startActivity(new Intent(getApplicationContext(), LogIn.class));
//                }
//                return true;

//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu2_main, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
}
