package com.example.aleksey.learnhebrew.adapters;


import android.content.Context;
import android.media.MediaPlayer;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aleksey.learnhebrew.R;
import com.example.aleksey.learnhebrew.singeltons.Letter;

public class AlphabetAdapter extends PagerAdapter {
    int currVolume;
    private Context context;
    LayoutInflater mLayoutInflater;

    public AlphabetAdapter(Context context) {
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return Letter.getInstance().getLetters().size();
    }

    @Override
    public void destroyItem(View collection, int position, Object view) {
        ((ViewPager) collection).removeView((View) view);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        View itemView = mLayoutInflater.inflate(R.layout.viewpager, container, false);

        ImageView letter = (ImageView) itemView.findViewById(R.id.letter);
        TextView letter1 = (TextView) itemView.findViewById(R.id.letterPropic);
        ImageButton audioButton = (ImageButton) itemView.findViewById(R.id.audioLetter);
        ImageView signRight = (ImageView) itemView.findViewById(R.id.rightSign);
        ImageView strelkaLeft = (ImageView) itemView.findViewById(R.id.leftSign);

//        // set size image
//        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),
//                LettersItem.getInstance().getLetters().get(position).getIdOriImage());
//
//        letter.setImageBitmap(Bitmap.createScaledBitmap(bitmap, 250, 250, true));

        letter.setImageResource(Letter.getInstance().getLetters().get(position).getIdIRForPechat());
        letter1.setText(Letter.getInstance().getLetters().get(position).getIdOriImage());

        // set audio file
        
        audioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(context, Letter.
                        getInstance().getLetters().get(position).getMusic());

                // это нужно для реализации возможности регулировки звука
//                int maxVolume = 100;
//
//                float log1 = (float) (Math.log(maxVolume - currVolume) / Math.log(maxVolume));
//                mediaPlayer.setVolume(1, 1 - log1);
                mediaPlayer.start();
            }
        });

        if (position != Letter.getInstance().getLetters().size() - 1) {
            signRight.setImageResource(R.drawable.prev);
        }
        if (position != 0) {
            strelkaLeft.setImageResource(R.drawable.backsign);
        }

        container.addView(itemView);
        return itemView;
    }

}