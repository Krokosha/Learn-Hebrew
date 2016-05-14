//package com.example.aleksey.learnhebrew.generals.Activites;
//
//import android.content.Context;
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ListView;
//import android.widget.Toast;
//
//import com.example.aleksey.learnhebrew.R;
//import com.example.aleksey.learnhebrew.generals.Word;
//import com.example.aleksey.learnhebrew.tools.CheckInternetConnection;
//import com.example.aleksey.learnhebrew.tools.UpdateFromParse;
//import com.example.aleksey.learnhebrew.adapters.WordsAdapter;
//import com.example.aleksey.learnhebrew.singeltons.Words;
//
//import java.util.ArrayList;
//
//public class ListOfMyWords extends AppCompatActivity {
//
//    private WordsAdapter adapterForWords;
//    private Context context;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list_of_my_words);
//
//        context = this;
//
//        ListView lv = (ListView) findViewById(R.id.lvOfMyWords);
//        adapterForWords = new WordsAdapter(context);
//        lv.setAdapter(adapterForWords);
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                if ((new CheckInternetConnection(
//                        context)).haveNetworkConnection()) {
//                    startActivityForResult((new Intent(context, Edit.class))
//                            .putExtra("position", position), 2);
//                }else {
//                    Toast.makeText(context, "Check internet connection",
//                            Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//        // check for the first time if something in the ArrayList
//        ArrayList<Word> array = Words.getInstance().getArrayWords();
//        if (array.isEmpty()) {
//            new UpdateFromParse(adapterForWords, context).updateFromParse();
//        }
//    }
//
//    public void addWords(View v) {
//        startActivityForResult(new Intent(context, AddWords.class), 1);
//    }
//
//    public void check(View view) {
//        startActivity(new Intent(context, CheckDictionary.class));
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if ((requestCode == 1 || requestCode == 2) && resultCode == RESULT_OK) {
//
//            // clear ArrayList for new updating.
//            // that listview don't duplicate words
//            Words.getInstance().getArrayWords().clear();
//            (new UpdateFromParse(adapterForWords, context)).updateFromParse();
//        }
//        else {
//            Toast.makeText(context, "Sorry, something go wrong. Try one more time...",
//                    Toast.LENGTH_SHORT).show();
//        }
//    }
//
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
//            case R.id.pesnya:
//                startActivity(new Intent(getApplicationContext(), Song.class));
//                return true;
//
//            case R.id.logout:
//                ParseUser.logOutInBackground(new LogOutCallback() {
//                    @Override
//                    public void done(ParseException e) {
//                        if (e == null) {
//                            Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                        }
//                    }
//                });
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu1_main, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//}
//
//
//
