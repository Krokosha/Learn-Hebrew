//package com.example.aleksey.learnhebrew.tools;
//
//
//import android.content.Context;
//import android.widget.BaseAdapter;
//import android.widget.Toast;
//
//import com.example.tanya_.learnhebrew.singeltons.Words;
//import com.example.tanya_.learnhebrew.generals.Word;
//import com.parse.FindCallback;
//import com.parse.ParseException;
//import com.parse.ParseObject;
//import com.parse.ParseQuery;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class UpdateFromParse {
//
//    private CheckInternetConnection cc;
//    private ProgressDialogClass dialog;
//    private BaseAdapter adapter;
//    private Context context;
//    private ArrayList<Word> array;
//
//    public UpdateFromParse(BaseAdapter adapter, Context context) {
//        this.adapter = adapter;
//        this.context = context;
//        this.adapter = adapter;
//        dialog = new ProgressDialogClass(context, "Progress start from UpdateFromParse class",
//                "Progress stop from UpdateFromParse class");
//        cc = new CheckInternetConnection(context);
//        array = Words.getInstance().getArrayWords();
//    }
//
//    public void updateFromParse() {
//
//        if (cc.haveNetworkConnection()) {
//            dialog.showProgressDialog();
//
//            ParseQuery<ParseObject> pq = ParseQuery.getQuery("MyDictionary");
//            pq.findInBackground(new FindCallback<ParseObject>() {
//                @Override
//                public void done(List<ParseObject> list, ParseException e) {
//                    if (e == null) {
//                        for (int index = 0; index < list.size(); index++) {
//                            Word word = new Word(
//                                    list.get(index).getString("hebrewWord"),
//                                    list.get(index).getString("wordTranscription"),
//                                    list.get(index).getString("wordTranslate"),
//                                    list.get(index).getObjectId());
//                            array.add(word);
//                        }
//                    } else {
//                        Toast.makeText(context, "sorry word wasn't saved in Parse" +
//                                " something go wrong with Parse", Toast.LENGTH_SHORT).show();
//                    }
//                    dialog.hideProgressDialog();
//                    // update items
//                    adapter.notifyDataSetChanged();
//                }
//            });
//        } else {
//            Toast.makeText(context, "Please check Internet connection", Toast.LENGTH_SHORT).show();
//        }
//    }
//}
