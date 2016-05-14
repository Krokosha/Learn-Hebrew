package com.example.aleksey.learnhebrew.singeltons;

import com.example.aleksey.learnhebrew.generals.LettersItem;

import java.util.ArrayList;

/*этот класс возвращает массив который содержит буквы*/

public class Letter {

    private ArrayList<LettersItem> letters;
    private static volatile Letter instanceForLetters;

    public Letter() {
        letters = new ArrayList<>();
    }

    public ArrayList<LettersItem> getLetters() {
        return letters;
    }

    public static Letter getInstance() {
        if (instanceForLetters == null) {
            synchronized (LettersItem.class){
                if (instanceForLetters == null){
                    instanceForLetters = new Letter();
                }
            }
        }
        return instanceForLetters;
    }
}
