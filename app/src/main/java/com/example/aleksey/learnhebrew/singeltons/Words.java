//package com.example.aleksey.learnhebrew.singeltons;
//
//import com.example.tanya_.learnhebrew.generals.Word;
//
//import java.util.ArrayList;
//
///*этот класс возвращает массив который сожержит слова*/
//
//public class Words {
//    private ArrayList<Word> words;
//    private static volatile Words instanceForWords;
//
//    private Words() {
//        words = new ArrayList<>();
//    }
//
//    public ArrayList<Word> getArrayWords() {
//        return words;
//    }
//
//    public static Words getInstance() {
//        if (instanceForWords == null) {
//            synchronized (Words.class) {
//                if (instanceForWords == null) {
//                    instanceForWords = new Words();
//                }
//            }
//        }
//        return instanceForWords;
//    }
//}
