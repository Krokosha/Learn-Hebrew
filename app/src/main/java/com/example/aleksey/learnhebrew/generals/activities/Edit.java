//package com.example.aleksey.learnhebrew.generals.Activites;
//
//import android.graphics.Color;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.example.aleksey.learnhebrew.R;
//import com.example.tanya_.learnhebrew.generals.Word;
//import com.example.tanya_.learnhebrew.tools.ProgressDialogClass;
//import com.example.tanya_.learnhebrew.singeltons.Words;
//import com.parse.DeleteCallback;
//import com.parse.ParseException;
//import com.parse.ParseObject;
//import com.parse.SaveCallback;
//
//public class Edit extends AppCompatActivity {
//    private Word obj;
//    private EditText hebrew;
//    private EditText transcription;
//    private EditText translate;
//    private ProgressDialogClass dialog;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_edit);
//
//        dialog = new ProgressDialogClass(this,"Open dialog with EDIT", "Close dialog with EDIT");
//
//        int objID = getIntent().getIntExtra("position", 0);
//        obj = Words.getInstance().getArrayWords().get(objID);
//
//        setItem();
//    }
//
//    private void setItem() {
//        hebrew = (EditText) findViewById(R.id.edit1);
//        hebrew.setText(obj.getHebrewWord());
//        hebrew.setTextColor(Color.BLACK);
//
//        transcription = (EditText) findViewById(R.id.edit2);
//        transcription.setText(obj.getWordTranslate());
//        transcription.setTextColor(Color.BLACK);
//
//        translate = (EditText) findViewById(R.id.edit3);
//        translate.setText(obj.getWordTranscription());
//        translate.setTextColor(Color.BLACK);
//    }
//
//    public void deleteObject1(View v) {
//
//        dialog.showProgressDialog();
//        ParseObject parseObject = ParseObject.createWithoutData("MyDictionary", obj.getObjectID());
//        parseObject.deleteInBackground(new DeleteCallback() {
//            @Override
//            public void done(com.parse.ParseException e) {
//                if (e == null) {
//                    Toast.makeText(getApplicationContext(), "was delete in parse",
//                            Toast.LENGTH_SHORT).show();
//                    setResult(RESULT_OK);
//                    dialog.hideProgressDialog();
//                    finish();
//                } else {
//                    Toast.makeText(getApplicationContext(), e.toString(),
//                            Toast.LENGTH_SHORT).show();
//                    setResult(RESULT_CANCELED);
//                    dialog.hideProgressDialog();
//                    finish();
//                }
//            }
//        });
//    }
//
//    public void editWord(View view) { // Нужно прописать функцию которая будет проверять все ли
//    // поля заполнил юзер и если поле не заполнено то выскакивает Алерт Диалог и предлагает
//    // заполнить поле, а если все поля удалены то предлагает удалить слово
//
//        dialog.showProgressDialog();
//
//        ParseObject parseObject = ParseObject.createWithoutData("MyDictionary", obj.getObjectID());
//
//        parseObject.put("hebrewWord", hebrew.getText().toString());
//        parseObject.put("wordTranslation", transcription.getText().toString());
//        parseObject.put("wordTranslate", translate.getText().toString());
//        parseObject.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                if (e == null) {
//                    Toast.makeText(getApplicationContext(), "was add to parse",
//                            Toast.LENGTH_SHORT).show();
//                    setResult(RESULT_OK);
//                    dialog.hideProgressDialog();
//                    finish();
//                } else {
//                    Toast.makeText(getApplicationContext(), e.getMessage(),
//                            Toast.LENGTH_SHORT).show();
//                    setResult(RESULT_CANCELED);
//                    dialog.hideProgressDialog();
//                    finish();
//                }
//            }
//        });
//    }
//}
