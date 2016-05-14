package com.example.aleksey.learnhebrew.generals.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.aleksey.learnhebrew.R;
import com.example.aleksey.learnhebrew.adapters.LettersAdapter;

public class Alphabet extends AppCompatActivity {
    private GridView gridView;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alfavit);

        context = this;
        LettersAdapter adapter = new LettersAdapter(context);
        gridView = (GridView) findViewById(R.id.gridView);
//        gridView.setRotationY(180);
        gridView.setAdapter(adapter);
//        letters.removeAll(letters);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context, MyImageView.class);
                intent.putExtra("obId", position);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        gridView.invalidateViews();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.main:
                startActivity(new Intent(context, MainActivity.class));
                return true;
//            case R.id.myDictionary:
//                if (ParseUser.getCurrentUser() != null) {
//                    startActivity(new Intent(context, ListOfMyWords.class));
//                } else {
//                    startActivity(new Intent(context, LogIn.class));
//                }
//                return true;
            case R.id.pesnya:
                startActivity(new Intent(context, Song.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
