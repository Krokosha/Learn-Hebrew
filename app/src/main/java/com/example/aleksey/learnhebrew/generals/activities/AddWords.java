//package com.example.aleksey.learnhebrew.generals.Activites;
//
//import android.content.Context;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.example.aleksey.learnhebrew.R;
//import com.example.aleksey.learnhebrew.tools.CheckInternetConnection;
//import com.example.aleksey.learnhebrew.tools.ProgressDialogClass;
//
//public class AddWords extends AppCompatActivity {
//    private Context context;
//    private ProgressDialogClass dialog;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add_words);
//        context = this;
//        dialog = new ProgressDialogClass(this, "Progress start from Addwords Class",
//                "Progress stop from Addwords Class");
//    }
//
//    public void saveWord(View v) {
//
//        CheckInternetConnection cc = new CheckInternetConnection(context);
//        boolean check = cc.haveNetworkConnection();
//
//        if (check) {
//
//            dialog.showProgressDialog();
//
//            EditText forHebrew = (EditText) findViewById(R.id.etHebrewWord);
//            String hebrew = forHebrew.getText().toString();
//
//            EditText forTranscription = (EditText) findViewById(R.id.etTranslation);
//            String transcription = forTranscription.getText().toString();
//
//            EditText forTranslate = (EditText) findViewById(R.id.etTranslate);
//            String translate = forTranslate.getText().toString();
//
//            ParseObject parseObject = new ParseObject("MyDictionary");
//            parseObject.put("hebrewWord", hebrew);
//            parseObject.put("wordTranscription", transcription);
//            parseObject.put("wordTranslate", translate);
//            parseObject.saveInBackground(new SaveCallback() {
//                @Override
//                public void done(ParseException e) {
//                    if (e == null) {
//                        Toast.makeText(getApplicationContext(), "Word was add to my dictionary",
//                                Toast.LENGTH_SHORT).show();
//                    } else Toast.makeText(getApplicationContext(), e.getMessage(),
//                            Toast.LENGTH_SHORT).show();
//                }
//
//
//            });
//
//            setResult(RESULT_OK);
//            dialog.hideProgressDialog();
//            finish();
//
//        }else { //Тут нужно реализовать SQL и записывать слова туда, а потом перегружать их в парс
//            Toast.makeText(getApplicationContext(), "Please connect to Internet, without this " +
//                            "you can't add new word", Toast.LENGTH_LONG).show();
//            setResult(RESULT_CANCELED);
//        }
//    }
//
//    public void back(View v) {
//        finish();
//    }
//}
