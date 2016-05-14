//package com.example.aleksey.learnhebrew.adapters;
//
//import android.content.Context;
//import android.graphics.Color;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import com.example.aleksey.learnhebrew.R;
//
//public class WordsAdapter extends BaseAdapter {
//
//    private Context contextForWords;
//
//    public WordsAdapter(Context contextForWords) {
//        this.contextForWords = contextForWords;
//    }
//
//    @Override
//    public int getCount() {
//        return Words.getInstance().getArrayWords().size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        RelativeLayout rl;
//
//        if (convertView != null) {
//            rl = (RelativeLayout) convertView;
//        } else {
//            LayoutInflater inflater = (LayoutInflater) contextForWords.getSystemService
//                    (Context.LAYOUT_INFLATER_SERVICE);
//            rl = (RelativeLayout) inflater.inflate(R.layout.word, parent, false);
//        }
//
//        Word obj = Words.getInstance().
//                getArrayWords().get(position);
//
//        TextView forHebrew = (TextView) rl.findViewById(R.id.tvForHebrew);
//        TextView forTranscription = (TextView) rl.findViewById(R.id.tvForTranscription);
//        TextView forTranslate = (TextView) rl.findViewById(R.id.tvForTranslate);
//
//        forHebrew.setText(obj.getHebrewWord());
//        forHebrew.setTextColor(Color.BLACK);
//
//        forTranscription.setText(obj.getWordTranscription());
//        forTranscription.setTextColor(Color.BLACK);
//
//        forTranslate.setText(obj.getWordTranslate());
//        forTranslate.setTextColor(Color.BLACK);
//
//        return rl;
//    }
//}
