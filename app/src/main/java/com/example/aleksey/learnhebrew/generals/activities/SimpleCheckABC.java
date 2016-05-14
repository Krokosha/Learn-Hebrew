package com.example.aleksey.learnhebrew.generals.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aleksey.learnhebrew.R;
import com.example.aleksey.learnhebrew.generals.LettersItem;
import com.example.aleksey.learnhebrew.singeltons.Letter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class SimpleCheckABC extends AppCompatActivity {
//    Должно наследовать от BaseCheckActivity

    private Button bCheck;
    private ImageButton bStart;
    private Context context;
    private Chronometer chronometer;
//    private ImageView tvLetter;
    private TextView tvLetter;

    private EditText etInputLatter;

    // -- состояние текущего теста. это может быть отдельный объект
    // список вопросов
    private List<LettersItem> list;
    // текущий вопрос
    private int currentLetter = 0;
    // время начала теста
    private long testStartTime;
    // количество ошибок
    private int mistake;
    // --

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_yourself);
        // поскольку там вроде как синглтон, а мы список перемешиваем, сделаем себе копию
        list = new ArrayList<>(Letter.getInstance().getLetters());

        context = this;
        etInputLatter = (EditText) findViewById(R.id.etAddLetter);
        tvLetter = (TextView) findViewById(R.id.tvLetter);
//        tvLetter.setImageResource(R.drawable.crocodile);

        // инициализация всех полей с элементами интерфейса в одном месте
        bCheck = (Button) findViewById(R.id.check);
        bStart = (ImageButton) findViewById(R.id.bStart);

        etInputLatter.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    checkYourself();
                    return true;
                }
                return false;
            }
        });
    }

    // обработчик кнопки "Старт", пользователь хочет начать тест
    public void startCheck(View v) {
        startCheck();
    }

    private void startChronometer() {
        chronometer = (Chronometer) findViewById(R.id.chronometer);
        chronometer.setBase(SystemClock.elapsedRealtime());
        chronometer.start();
    }

    protected void startCheck() {
        etInputLatter.setVisibility(View.VISIBLE);

        bCheck.setEnabled(true);
//        bStart.setEnabled(false);

        bStart.setVisibility(View.INVISIBLE);

        startChronometer();  // запустили часы
        shuffleList(list);   // перетасовали буквы
        currentLetter = 0;   // начинаем с первой

        testStartTime = System.currentTimeMillis(); // устанавливаем время начала теста

        showCurrentLetter(); // показываем
    }

    private void showCurrentLetter() {
        if (currentLetter < list.size()) {
//            ivLetter.setImageResource(list.get(currentLetter).getIdIRForPechat());
            tvLetter.setText(list.get(currentLetter).getTranscription());
        } else {
            // если буквы кончились, ничего не показываем
//            ivLetter.setImageDrawable(null);
            tvLetter.setText("");
        }
    }

    private void nextStep() {
        currentLetter++;
        if (currentLetter < list.size()) {
            showCurrentLetter();
        } else {
            completeTest();
        }
    }

    private void completeTest() {
        // приводим интерфейс в состояние до начала теста
        chronometer.stop();
        chronometer.setBase(SystemClock.elapsedRealtime());

        tvLetter.setText("");
        etInputLatter.setText("");

        bStart.setEnabled(true);
        bCheck.setEnabled(false);

        // готовим и выводим пользователю сообщение
        final long totalTime = System.currentTimeMillis() - testStartTime;
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(totalTime);
        final SimpleDateFormat format = new SimpleDateFormat("mm:ss");

        AlertDialog.Builder builder = new AlertDialog.Builder(SimpleCheckABC.this);
        builder.setTitle("Results!")
                .setMessage("Your mistake : " + mistake + "\n" + "Your time : " +
                        format.format(cal.getTime()) + "\n" + "Do you want try again?")
                .setIcon(R.drawable.goodresault)
                .setCancelable(false)
                .setNegativeButton("I want try again!",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                startCheck();
                            }
                        })
                .setPositiveButton("Cancel ",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                finish();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }


    public void checkYourself(View v) {
        checkYourself();
    }

    // Пользователь нажал на кнопку "Ответить"
    private void checkYourself() {
        String inputLatter = etInputLatter.getText().toString();
        // берем букву от текущего вопроса
        String currentEntry = list.get(currentLetter).getKeyboardInput();

        // проверяем, что он там навводил
        if (inputLatter.isEmpty())
            Toast.makeText(context, "enter you answer", Toast.LENGTH_SHORT).show();
        else {
            if (currentEntry.equals(inputLatter)) {
                // правильный ответ, нужно показать следующий вопрос

                Toast toast = Toast.makeText(context, "you are right", Toast.LENGTH_SHORT);
                toast.show();
                // Протестить может нужно будет делать в отдельном потоке
                // ПРОВЕРИТЬЬЬЬЬЬ
                //                toast.setGravity(Gravity.CENTER, 0, 0);
//                LinearLayout toastContainer = (LinearLayout) toast.getView();
//                ImageView catImageView = new ImageView(getApplicationContext());
//                catImageView.setImageResource(R.drawable.goodresault);
//                toastContainer.addView(catImageView, 0);
                etInputLatter.setText("");

                nextStep(); // следующий шаг
            } else {
                // неправильный ответ, увеличиваем счетчик ошибок и оставляем вопрос, как есть
                mistake += 1;
                Toast.makeText(context, "try one more", Toast.LENGTH_SHORT).show();

                etInputLatter.setText("");
            }
        }
    }

    static void shuffleList(List<LettersItem> list) {
        Collections.shuffle(list);
    }

    public void backToABC(View v) {
        finish();
    }
}