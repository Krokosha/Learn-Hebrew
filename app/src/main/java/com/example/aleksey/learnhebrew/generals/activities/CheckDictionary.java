//package com.example.aleksey.learnhebrew.generals.Activites;
//
//import android.app.AlertDialog;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.os.SystemClock;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.Chronometer;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.aleksey.learnhebrew.R;
//import com.example.tanya_.learnhebrew.generals.Word;
//import com.example.tanya_.learnhebrew.singeltons.Words;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//
//public class CheckDictionary extends AppCompatActivity {
//
//    private int finish;
//    private int number;
//    private int mistake;
//    private boolean stopWhile;
//    private Button bCheck;
//    private Button bStartCheck;
//    private TextView etOutput;
//    private EditText etInputWord;
//    private Chronometer chronometer;
//    private Context context;
//    private ArrayList<Word> array;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_check_your_dictionary);
//
//        context = this;
//        array = Words.getInstance().getArrayWords();
//        bCheck = (Button) findViewById(R.id.bCheckWord);
//        bCheck.setEnabled(false);
//        bStartCheck = (Button) findViewById(R.id.bStartWord);
//    }
//
//    public void startCheckWord(View view) {
//        bCheck.setEnabled(true);
//        bStartCheck.setEnabled(false);
//
//        startChronometer();
//
//        new StartCheck().start();
//    }
//
//    private void startChronometer() {
//        chronometer = (Chronometer) findViewById(R.id.chronometer2); //запускаем отчет времени, чтоб
//        // знать сколько user тратит времени на выполнение
//        chronometer.setBase(SystemClock.elapsedRealtime());
//        chronometer.start();
//    }
//
//    // этот класс выполняет тест
//    private class StartCheck extends Thread {
//        @Override
//        public void run() {
//            super.run();
//
//            finish = 0;
//            choiceVar();
//            finalCheck(System.currentTimeMillis());
//        }
//        // этот метод случайным образом подбирает обьекты для сравнения
//        private void choiceVar() {
//            int[] mes = getInts();
//            int i = 0;
//            boolean check = true;
//            while (finish < array.size()) {
//                number = (int) (Math.random() * (array.size()));
//                for (int obj : mes) {
//                    if (number == obj) {
//                        check = false;
//                        break;
//                    } else check = true;
//                }
//                if (check) {
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            etOutput = (TextView) findViewById(R.id.tvShowWord);
//                            etOutput.setText(array.get(number).getWordTranslate());
//                        }
//                    });
//                    mes[i] = number;
//                    i += 1;
//                    while (!stopWhile) {
//                        SystemClock.sleep(1000);
//                    }
//                    stopWhile = false;
//                }
//            }
//        }
//
//        // этот метод вызывает алертдиалог и устанавает результирующие покащатели
//        private void finalCheck(long startTime) {
//            if (finish == array.size()) {
//                chronometer.stop();
//                final String putAnswer = "put your answer hire";
//                final long totalTime = System.currentTimeMillis() - startTime;
//                final Calendar cal = Calendar.getInstance();
//                cal.setTimeInMillis(totalTime);
//                final SimpleDateFormat format = new SimpleDateFormat("mm:ss");
//
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        etInputWord.setText(putAnswer);
//                        chronometer.setBase(SystemClock.elapsedRealtime());
//                        etOutput.setText("");
//
//                        AlertDialog.Builder builder = new AlertDialog.Builder(CheckDictionary.this);
//                        builder.setTitle("Results!")
//                                .setMessage("Your mistake : " + mistake + "\n" + " Your time : " +
//                                        format.format(cal.getTime()))
//                                .setIcon(R.drawable.ain)
//                                .setCancelable(true)
//                                .setNegativeButton("Ok",
//                                        new DialogInterface.OnClickListener() {
//                                            public void onClick(DialogInterface dialog, int id) {
//                                                dialog.cancel();
//                                            }
//                                        });
//                        AlertDialog alert = builder.create();
//                        alert.show();
//                        bStartCheck.setEnabled(true);
//                        bCheck.setEnabled(false);
//                    }
//                });
//            }
//        }
//
//        //эта функция возвращает массив все ячейки которого заполнены "-1"
//        private int[] getInts() {
//            int[] mes = new int[array.size()];
//            for (int i = 0; i < mes.length; i++) {
//                mes[i] = -1;
//            }
//            return mes;
//        }
//    }
//
//    public void checkWord(View v) {
//        etInputWord = (EditText) findViewById(R.id.etAddWord);
//        String inputWord = etInputWord.getText().toString();
//
//        if (inputWord.isEmpty())
//            Toast.makeText(context, "enter you answer", Toast.LENGTH_SHORT).show();
//        else {
//            if (array.get(number).getHebrewWord().equals(inputWord)) {
//                Toast.makeText(context, "you are right", Toast.LENGTH_SHORT).show();
//                etInputWord.setText("");
//                finish += 1;
//                this.stopWhile = true;
//            }
//            if (!inputWord.equals(array.get(number).getHebrewWord())) {
//                mistake += 1;
//                Toast.makeText(context, "try one more", Toast.LENGTH_SHORT).show();
//                etInputWord.setText("");
//            }
//        }
//    }
//
//    public void backToWord(View view) {
//        finish();
//    }
//}
