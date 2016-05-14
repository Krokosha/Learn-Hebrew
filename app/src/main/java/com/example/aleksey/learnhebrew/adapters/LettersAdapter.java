package com.example.aleksey.learnhebrew.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.aleksey.learnhebrew.singeltons.Letter;

public class LettersAdapter extends BaseAdapter {

    private Context contextForLetters;

    public LettersAdapter(Context context) {
        this.contextForLetters = context;
    }

    @Override
    public int getCount() {
        return Letter.getInstance().getLetters().size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // makes adapter work faster and set letters in gridview
        ImageView imageView;

        if (convertView != null) {
            imageView = (ImageView) convertView;
        } else {
            imageView = new ImageView(contextForLetters);
            imageView.setRotationY(180);
            imageView.setBackgroundResource(Letter.getInstance().getLetters().
                    get(position).getIdIRForPechat());
        }
        return imageView;
    }
}
