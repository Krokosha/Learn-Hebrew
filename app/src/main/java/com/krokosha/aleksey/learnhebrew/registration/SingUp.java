//package com.example.aleksey.learnhebrew.registration;
//
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.example.aleksey.learnhebrew.R;
//import com.example.tanya_.learnhebrew.generals.Activites.ListOfMyWords;
//import com.parse.ParseException;
//import com.parse.ParseUser;
//import com.parse.SignUpCallback;
//
//public class SingUp extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sing_up);
//    }
//
//    public void registration(View view) {
//        EditText editText = (EditText) findViewById(R.id.mail);
//        String email = editText.getText().toString();
//        EditText editText1 = (EditText) findViewById(R.id.password);
//        String password = editText1.getText().toString();
//        EditText editText2 = (EditText) findViewById(R.id.rePassword);
//        String rePassword = editText2.getText().toString();
//
//        if (password.equals(rePassword)) {
//            ParseUser pu = new ParseUser();
//            pu.setUsername(email);
//            pu.setPassword(password);
//            pu.signUpInBackground(new SignUpCallback() {
//                @Override
//                public void done(ParseException e) {
//                    if (e == null) {
//                        Toast.makeText(getApplicationContext(), "ok",
//                                Toast.LENGTH_SHORT).show();
//                        startActivity(new Intent(getApplicationContext(),
//                                ListOfMyWords.class));
//                    } else Toast.makeText(getApplicationContext(), e.getMessage(),
//                            Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
//    }
//
//
//}
