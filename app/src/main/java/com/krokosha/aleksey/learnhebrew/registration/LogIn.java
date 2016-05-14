//package com.example.aleksey.learnhebrew.registration;
//
//import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.aleksey.learnhebrew.R;
//import com.example.aleksey.learnhebrew.Activites.ListOfMyWords;
//import com.parse.LogInCallback;
//import com.parse.ParseException;
//import com.parse.ParseUser;
//
//public class LogIn extends AppCompatActivity {
//    private boolean flag = false;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_registration_email);
//    }
//
//
//    public void logIn(View view) {
//        EditText editText = (EditText) findViewById(R.id.logInMail);
//        editText.setVisibility(View.VISIBLE);
//        String mail = editText.getText().toString();
//        EditText editText1 = (EditText) findViewById(R.id.logInPassword);
//        editText1.setVisibility(View.VISIBLE);
//        String password = editText1.getText().toString();
//        TextView textView = (TextView) findViewById(R.id.forgotPassword);
//        textView.setVisibility(View.VISIBLE);
//
//
//        if (flag) {
//            if (!mail.isEmpty() && !password.isEmpty()) {
//                ParseUser.logInInBackground(mail, password, new LogInCallback() {
//                    @Override
//                    public void done(ParseUser parseUser, ParseException e) {
//                        if (e == null) {
//                            Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(getApplicationContext(), ListOfMyWords.class));
//                        } else Toast.makeText(getApplicationContext(), "try one more",
//                                Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }Toast.makeText(getApplicationContext(), "you didn't fill data",
//                    Toast.LENGTH_SHORT).show();
//        }
//        flag = true;
//    }
//
//
//    public void intentSingUp(View view) {
//        startActivity(new Intent(getApplicationContext(), SingUp.class));
//    }
//
//    public void sendPassword(View view) {
//        startActivity(new Intent(getApplicationContext(), ForgotPassword.class));
//    }
//}
