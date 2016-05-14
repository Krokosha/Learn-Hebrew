package com.example.aleksey.learnhebrew.generals.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.aleksey.learnhebrew.R;
import com.example.aleksey.learnhebrew.generals.LettersItem;
import com.example.aleksey.learnhebrew.singeltons.Letter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<LettersItem> letters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newone);

        letters = Letter.getInstance().getLetters();
        listLettersInit();
    }

    public void songPage(View view) {
        startActivity(new Intent(getApplicationContext(), Song.class));
    }


    public void pechatLetters(View v) {
        startActivity(new Intent(getApplicationContext(), Alphabet.class));
    }

    public void checkIntent(View view) {
        startActivity(new Intent(getApplicationContext(), SimpleCheckABC.class));
    }

    public void poempage(View view) {
        startActivity(new Intent(getApplicationContext(), PoemAlphabet.class));
    }

    public void listLettersInit() {
        letters.add(new LettersItem("alef", R.drawable.alef, "Алеф",
                "Алеф", R.raw.aleph, "א"));
        letters.add(new LettersItem("bet", R.drawable.bet, "Бэт",
                "Бет", R.raw.bet, "ב"));
        letters.add(new LettersItem("gimel", R.drawable.gimel, "Гимель",
                "Гимель", R.raw.gimmel, "ג"));
        letters.add(new LettersItem("dalet", R.drawable.dalet, "Далет",
                "Далет", R.raw.dalet, "ד"));

        letters.add(new LettersItem("hei", R.drawable.hei, "hей",
                "Хей", R.raw.hey, "ה"));
        letters.add(new LettersItem("vav", R.drawable.vav, "Вав",
                "Вав", R.raw.vav, "ו"));
        letters.add(new LettersItem("zain", R.drawable.zain, "Заин",
                "Заин", R.raw.zayin, "ז"));
        letters.add(new LettersItem("xet", R.drawable.xet, "Хэт",
                "Хет", R.raw.chet, "ח"));

        letters.add(new LettersItem("tet", R.drawable.tet, "Тэт",
                "Тет", R.raw.tet, "ט"));
        letters.add(new LettersItem("iod", R.drawable.you, "Йуд",
                "Йуд", R.raw.yod, "י"));
        letters.add(new LettersItem("kaf", R.drawable.kaf, "Каф",
                "Каф", R.raw.kaf, "כ"));
        letters.add(new LettersItem("kafSofit", R.drawable.kafsofit, "Каф софит",
                "Каф софит", R.raw.kaf, "ך"));

        letters.add(new LettersItem("lamed", R.drawable.lamed, "Ламэд",
                "Ламед", R.raw.lamed, "ל"));
        letters.add(new LettersItem("mem", R.drawable.mem, "Мэм",
                "Мем", R.raw.mem, "מ"));
        letters.add(new LettersItem("memSofit", R.drawable.memsofit, "Мэм софит",
                "Мем софит", R.raw.mem_sofit, "ם"));
        letters.add(new LettersItem("nyn", R.drawable.nun, "Нун",
                "Нун", R.raw.nun, "נ"));

        letters.add(new LettersItem("nynSofit", R.drawable.nunsofit, "Нун софит",
                "Нун софит", R.raw.nun_sofit, "ן"));
        letters.add(new LettersItem("camex", R.drawable.camex, "Самэх",
                "Самех", R.raw.samech, "ס"));
        letters.add(new LettersItem("ain", R.drawable.ain, "Аин",
                "Аин", R.raw.ayin, "ע"));
        letters.add(new LettersItem("pei", R.drawable.pei, "Пэй",
                "Пей", R.raw.pey, "פ"));

        letters.add(new LettersItem("peiSofit", R.drawable.peisofit, "Пэй софит",
                "Пей софит", R.raw.pey, "ף"));
        letters.add(new LettersItem("cadi", R.drawable.cadi, "Цадик",
                "Цади", R.raw.tsadie, "צ"));
        letters.add(new LettersItem("cadiSofit", R.drawable.cadisofit, "Цадик софит",
                "Цади софит", R.raw.tsadie_sofit, "ץ"));
        letters.add(new LettersItem("kof", R.drawable.kuf, "Куф",
                "Каф", R.raw.kaf, "ק"));

        letters.add(new LettersItem("reish", R.drawable.reish, "Рэйш",
                "Рейш", R.raw.resh, "ר"));
        letters.add(new LettersItem("shin", R.drawable.shin, "Шин",
                "Шин", R.raw.shin, "ש"));
        letters.add(new LettersItem("tav", R.drawable.tav, "Тав",
                "Тав", R.raw.tav, "ת"));
    }
}
